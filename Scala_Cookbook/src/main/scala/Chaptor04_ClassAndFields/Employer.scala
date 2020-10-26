package Chaptor04_ClassAndFields

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Employer(
					  firstName: String,
					  lastName: String,
					  var salary: Int
			  ) extends Person(firstName, lastName)
	

object Employer extends App {
	
	val employer: Employer = new Employer("john", "wayen", 20000)
	println(s"firstName: ${employer.firstName}, lastName: ${employer.lastName}, salary: ${employer.salary}")
}
