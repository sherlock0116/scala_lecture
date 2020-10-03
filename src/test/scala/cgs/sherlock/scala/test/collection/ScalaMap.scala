package cgs.sherlock.scala.test.collection

import org.scalatest.funsuite.AnyFunSuite

import scala.collection._

/**
 * Descriptor:
 * Author: sherlock
 */
class ScalaMap extends AnyFunSuite{

	test("scala Map的构建方式") {
		val m1 = Map(
			"JPN" -> "Tokyo",
			"USA" -> "Washington",
			"UK" -> "London"
		)
		val m2 = mutable.Map(
			"JPN" -> "Tokyo",
			"USA" -> "Washington",
			"UK" -> "London"
		)
		val m3 = new mutable.HashMap[String, String]()

		val m4 = Map(
			("JPN", "Tokyo"),
			("USA", "Washington"),
			("UK", "London")
		)
		val (k, v) = m4.unzip
		k.foreach(e => print(s"{${e} -> ${m4.getOrElse(e, " ")}} "))
	}

}
