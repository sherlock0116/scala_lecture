package Chaptor08_UsingCollections

import scala.collection.immutable

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object PowOfFor extends App {
	
	for (_ <- 1 to 3) {
		println("ho ")
	}
	
	val result: immutable.IndexedSeq[Int] = for (i <- 1 to 10)
		yield i * 2
	
	val result2 = (1 to 10).map(_ * 2)
	
	val doubleEven = for (i <- 1 to 10; if i % 2 == 0) yield i * 2
}
