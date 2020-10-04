package Chaptor07_UsingTraits.traits

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
trait Friend {
	
	val name: String
	def listen(): Unit = println(s"Your friend $name is listening.")
}
