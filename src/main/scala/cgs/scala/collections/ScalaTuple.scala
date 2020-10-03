package cgs.scala.collections

/**
 * Descriptor:
 * Author: sherlock
 */
object ScalaTuple {

	def main(args: Array[String]): Unit = {

		// 直接定义一个 tuple
		val tp1 = (1, 2.1, "String")
		val tp2 = Tuple3(1, 2.1, "String")
		val (firstname, lastname, email) = ("Venkat", "Subramaniam", "Venkat@agiledeveloper.com")
		println(tp1.getClass)
		
		println(s"first-name: $firstname\nlast-name: $lastname\nemail: $email")
	}
}
