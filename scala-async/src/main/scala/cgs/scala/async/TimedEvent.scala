package cgs.scala.async

import java.util.{Timer, TimerTask}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scala.async.Async.{async, await}
import scala.io.StdIn


/**
 * @Description  TODO
 * @Author  sherlock
 * @Date
 */

object TimedEvent {

	val timer: Timer = new Timer()

	/**
	 * Return a Future which completes successfully with the supplied value after secs seconds.
	 * @param secs delayed
	 * @param value relsult
	 * @tparam T type
	 * @return
	 */
	def delayedSuccess[T] (secs: Int, value: T): Future[T] = {
		val result: Promise[T] = Promise[T]
		timer.schedule(new TimerTask {
			override def run(): Unit = {
				result.success(value)
			}
		}, secs * 1000)
		result.future
	}


	def delayedFailure(secs: Int, msg: String): Future[Int] = {
		val result: Promise[Int] = Promise[Int]
		timer.schedule(new TimerTask {
			override def run(): Unit = {
				result.failure(new IllegalArgumentException(msg))
			}
		}, secs * 1000)
		result.future
	}

}

/**
 * 						  ----------
 *                           | task1   |	(2S)
 * 						  ----------
 * 								|
 * 					-----------------
 * 					|						|
 * 			---------				---------
 * 			| task2 |	(4S)		| task3 | (6S)
 * 			---------				---------
 * 					|						|
 * 					-----------------
 * 								|
 * 						  ----------
 * 						  | task4  | (2S)
 * 						  ----------
 * 		task1, [task2, task3], task4 串行 (10S)
 * 		task2, task3并行
 */
object TestTimedEvent extends App {

	def task1(input: Int) = TimedEvent.delayedSuccess(2, input)
	def task2(input: Int) = TimedEvent.delayedSuccess(4, input + 2)
	def task3(input: Int) = TimedEvent.delayedSuccess(6, input + 3)
	def task4(input: Int) = TimedEvent.delayedSuccess(2, input + 4)

	/*
		Duration.Inf = 无限期阻塞, Inf(Infinite: 想起了复联里的无限原石......)

	 */
	def runBlocking() = {
		val v1: Int = Await.result(task1(1), Duration.Inf)
		val v2: Int = Await.result(task2(v1), Duration.Inf)
		val v3: Int = Await.result(task3(v1), Duration.Inf)
		val v4: Int = Await.result(task4(v2 + v3), Duration.Inf)
		val result: Promise[Int] = Promise[Int]
		result.success(v4)
		result.future
	}

	def runOnSuccess() = {
		val result: Promise[Int] = Promise[Int]
		task1(1).onSuccess {
			case v1 =>
				val a: Future[Int] = task2(v1)
				val b: Future[Int] = task3(v1)
				a.onSuccess {
					case v2 =>
						b.onSuccess {
							case v3 =>
								task4(v2 + v3).onSuccess {
									case x => result.success(x)
							}
						}
				}
		}
		result.future
	}

	def runFlatMap() = {
		task1(1) flatMap {v1 =>
			val a: Future[Int] = task2(v1)
			val b: Future[Int] = task3(v1)
			a flatMap { v2 =>
				b flatMap { v3 => task4(v2 + v3) }}
		}
	}

	def runBlockingWithFailure() = {
		val result: Promise[Int] = Promise[Int]
		try {
			val v1: Int = Await.result(task1(1), Duration.Inf)
			val future2: Future[Int] = task2(v1)
			val future3: Future[Int] = task3(v1)
			val v2: Int = Await.result(future2, Duration.Inf)
			val v3: Int = Await.result(future3, Duration.Inf)
			val v4: Int = Await.result(task4(v2 + v3), Duration.Inf)
			result.success(v4)
		} catch {
			case t: Throwable => result.failure(t)
		}
		result.future
	}

	def runOnComplete() = {
		val result: Promise[Int] = Promise[Int]
		task1(1).onComplete {
			case Success(v1) =>
				val a: Future[Int] = task2(v1)
				val b: Future[Int] = task3(v1)
				a.onComplete {
					case Success(v2) =>
						b.onComplete {
							case Success(v3) => task4(v2 + v3).onComplete {
								case Success(x) => result.success(x)
								case Failure(t) => result.failure(t)
							}
							case Failure(t) => result.failure(t)
						}
					case Failure(t) => result.failure(t)
				}
			case Failure(t) => result.failure(t)
		}
		result.future
	}

	def runAsync() = {
		async {
			val v1: Int = await(task1(1)) // 1
			val a: Future[Int] = task2(v1) // 1 + 2 = 3
			val b: Future[Int] = task3(v1) // 1 + 3 = 4
			await(task4(await(a) + await(b)))
		}
	}

	private val start: Long = System.currentTimeMillis()
	println(Await.result(runAsync(), Duration.Inf)) // 阻塞获取运行结果
	private val end: Long = System.currentTimeMillis()
	println(s"time cost: [${(end - start)/1000}s]")


//	StdIn.readLine()

}
