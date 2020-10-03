package cgs.scala.collections

/**
 * Descriptor:
 * Author: sherlock
 */
class ScalaList {

	def main(args: Array[String]): Unit = {

		val l1 = Nil
		val l2 = List(1, 2, 3, 4)

		val l3 = l2 :+ "a"
		l3.foreach(print(_))

		// :: 头插法
		val l4 = "a" :: "b" :: "c" :: l2 :: l1
		l4.foreach(println(_))
	}
}
