package cgs.scala.constructor

/**
 * Descriptor:
 * Author: sherlock
 */
class BlueCat(
					 var name: String,
					 var gender: String,
					 var age: Int,
					 val owner: String) {


	println("entering class BuleCat{ }")
}

object BlueCat {

	def main(args: Array[String]): Unit = {
		val blueCat = new BlueCat("blue", "male", 2, "sherlock")
		println(s"Bluecat: ${blueCat.name}, ${blueCat.gender}, ${blueCat.age}, ${blueCat.owner}")

	}
}