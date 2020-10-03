package Chaptor04_WorkingWithObjects

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Construct(param: String) {
	
	println(s"Creating an instance of Construct with param: $param")
}

object Construct extends App {
	
	println("Let's create an instance")
	val construct: Construct = new Construct("sample")
}