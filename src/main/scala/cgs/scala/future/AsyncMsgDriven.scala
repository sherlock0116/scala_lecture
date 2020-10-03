package cgs.scala.future

import java.util.concurrent.{CountDownLatch, TimeUnit}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * @Project: scala_lecture
 * @Description: TODO
 * @author: sherlock
 * @date Date: 
 */
object AsyncMsgDriven extends App {

	var num = 1;

	@volatile var flag = true

	val future = Future {
		println("准备执行异步 Future")
		TimeUnit.SECONDS.sleep(5L)
		flag = false
		"成功"
	}
	future.onComplete(rel => {
		println(s"Future 异步执行结束啦, 结果是${rel}")
	})
	while (flag) {
		println(s"我是主线程啦! ${num}")
		num += 1
		TimeUnit.SECONDS.sleep(1L)
	}



}
