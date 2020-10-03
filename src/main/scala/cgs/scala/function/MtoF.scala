package cgs.scala.function

/**
 * Descriptor:
 * Author: sherlock
 */
object MtoF {

	def main(args: Array[String]): Unit = {

		// convert method to function
		def f1 = new MtoF().sum _
		println(s"f1 = ${f1}")

		// define a function
		val f2 = (a: Int, b: Int) => a + b
		println(s"f2 = ${f2}")
	}
}

class MtoF {

	def sum(a: Int, b: Int) = {
		a + b
	}

	def print(s: String) = {
		println(s)
	}
}
