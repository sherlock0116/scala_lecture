package Chaptor04_WorkingWithObjects

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class PoliceOfficer(name: String)

object CopApp extends App {
	
	type Cop = PoliceOfficer
	
	val jack: Cop = new Cop("Jack")
	println(jack.getClass)
}