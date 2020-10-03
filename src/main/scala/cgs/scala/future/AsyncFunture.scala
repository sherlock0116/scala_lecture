package cgs.scala.future

import java.util.concurrent.TimeUnit

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.StdIn
import scala.util.{Failure, Success}

/**
 * Descriptor:
 * Author: sherlock
 */
object AsyncFunture {

	def main(args: Array[String]): Unit = {
		println("main starting......")
		val block = {
			println("main sleeping......")
			TimeUnit.SECONDS.sleep(2L)
		}
		val rel = Future{
			println("future sleeping......")
			TimeUnit.SECONDS.sleep(5L)
			println("future waking......")
			20L
		}

		/*
		// 阻塞的方式获取 Future 中的执行结果, 超时获取不到则报错. 多用于测试
		println(Await.result(rel, 6 seconds))
		println("Await ending......")
		*/

		// 回调函数获取 Future 中的执行结果, 非阻塞
		/*rel.onComplete {
			case Success(value) => println(s"onComplete: ${value}")
			case Failure(exception) => println(s"An error has occured: ${exception.getMessage}")
		}*/

		// 阻塞当前线程(main)
		Await.result(rel, Duration.Inf)

		println("main ending......")

		StdIn.readLine()
	}
}
