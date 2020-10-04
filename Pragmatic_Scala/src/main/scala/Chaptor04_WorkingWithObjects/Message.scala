package Chaptor04_WorkingWithObjects

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Message[T](val content: T) {
	
	override def toString: String = {
		s"message content is $content"
	}
	
	def is(value: T): Boolean = value == content
}

object Message extends App {
	
	val msg1: Message[String] = new Message("howdy")
	val msg2: Message[Int] = new Message(42)
	
	println(msg1)
	println(msg2)
	println(msg1 is "howdy")
	println(msg2 is 42)
	println(msg2 is 23)
}