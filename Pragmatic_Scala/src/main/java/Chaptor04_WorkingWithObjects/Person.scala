package Chaptor04_WorkingWithObjects

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Person(val firstName: String, val lastName: String) {
	
	var position: String = _
	
	def this(firstName: String, lastName: String, positionHeld: String) {
		this(firstName, lastName)
		position = positionHeld
	}
	
	override def toString: String = {
		s"$firstName $lastName holds $position position"
	}
	
	println(s"Creating $toString")
}

object Person extends App {
	
	val john: Person = new Person("John", "Smith", "Analyst")
	println(s"$john\n")
	
	val bill: Person = new Person("Bill", "Walker")
	println(bill)
}