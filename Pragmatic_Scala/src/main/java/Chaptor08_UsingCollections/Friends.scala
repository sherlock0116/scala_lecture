package Chaptor08_UsingCollections

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Friends extends App {
	
	val friends = List(
		Person("Brian", "Sletten"),
		Person("Neal", "Ford"),
		Person("Scott", "Davis"),
		Person("Stuart", "Halloway")
	)
	
	val lastNames: List[String] = for (friend <- friends; lastName = friend.lastName) yield lastName
	println(lastNames.mkString(", "))
	
	for (i <- 1 to 3; j <- 4 to 6) {
		print(s"[$i, $j] ")
	}
}

class Person(val firstName: String, val lastName:String)

object Person {
	
	def apply(firstName: String, lastName: String): Person = new Person(firstName, lastName)
}