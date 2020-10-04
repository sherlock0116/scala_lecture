package Chaptor05_WorkingUseOfTypes

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */

class Name(val value: String) extends AnyVal {
	
	override def toString: String = value
	def length: Int = value.length
}

object NameExample extends App {
	
	def printName(name: Name): Unit = {
		println(name)
	}
	
	val name: Name = new Name("Snowy")
	println(name.length)
	printName(name)
}
