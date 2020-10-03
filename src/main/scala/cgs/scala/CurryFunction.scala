package cgs.scala

/**
 * Descriptor:
 * Author: sherlock
 */
object ImplicitClass {

	implicit class Check(val s1: String) {

		def eqs(s2: String)(f: (String, String) => Boolean) = {
			f(s1, s2)
		}
	}
}

object CurryFunction {

	def main(args: Array[String]): Unit = {

		def f1 = (a: String, b: String) => a.toLowerCase.equals(b.toLowerCase)

		import ImplicitClass._
		val str1 = "ragDoll"
		val str2 = "Ragdoll"
		println(str1.eqs(str2)(f1))
	}

}