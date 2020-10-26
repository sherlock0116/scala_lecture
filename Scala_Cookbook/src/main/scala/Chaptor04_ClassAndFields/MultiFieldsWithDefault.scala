package Chaptor04_ClassAndFields

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object MultiFieldsWithDefault extends App {
	
	println(new Socket)
	println(new Socket(timeout = 2000))
	println(new Socket(linger = 1000))
}

class Socket(val timeout: Int = 10000, val linger: Int = 2000) {
	override def toString: String = s"timeout: $timeout, linger: $linger"
}



