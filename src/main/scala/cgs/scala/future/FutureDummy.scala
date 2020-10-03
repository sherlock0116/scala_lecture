package cgs.scala.future

import java.util.concurrent.TimeUnit


import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * @descriptor:
 * @author: sherlock
 */
object FutureDummy extends App {

	var i, j = 0
	(1 to 10000).foreach(_ => Future(i = i + 1))
	(1 to 10000).foreach(_ => j = j + 1)
	TimeUnit.SECONDS.sleep(1L)
	println(s"i = ${i}, j = ${j}")

}
