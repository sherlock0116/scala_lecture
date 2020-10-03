package Chaptor08_UsingCollections

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Colon extends App {
	
	val cow = new Cow
	val moon = new Moon
	
	cow ^ moon
	println("=" * 20)
	cow ^: moon
}

class Cow {
	def ^(moon:Moon): Unit = println("Cow jumped over the moon")
}

class Moon {
	
	def ^:(cow: Cow): Unit = println("This cow jumped over the moon too")
}