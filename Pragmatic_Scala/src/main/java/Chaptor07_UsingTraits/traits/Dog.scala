package Chaptor07_UsingTraits.traits

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Dog(val name: String) extends Animal with Friend {
	
	override def listen(): Unit = println(s"$name's listening quietly")
}
