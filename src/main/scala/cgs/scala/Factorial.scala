package cgs.scala

/**
 * Descriptor:
 * Author: sherlock
 */
object Factorial {

	def factorial(x: BigInt): BigInt = {
		if (x == 0) 1 else x * factorial(x - 1)
	}

	def main(args: Array[String]): Unit = {
		val x = 3
		println(s"${x}! = ${factorial(x)}")

		val xs = 1 to 3
		val it = xs.iterator

	}
}
