package cgs.sherlock.scala.test.collection

import org.scalatest.funsuite.AnyFunSuite

/**
 * Descriptor:
 * Author: sherlock
 */
class ScalaList extends AnyFunSuite {

	test("List集合头插法") {
		val l1 = List(1, 2, 3)
		val l2 = "a" :: "b" :: "c" :: l1 :: Nil
		l2.foreach(println(_))
	}

	test("List打平后的头插法") {
		val l1 = List(1, 2, 3)
		val l2 = "a" :: "b" :: "c" :: l1 ::: Nil
		l2.foreach(println(_))
	}

}
