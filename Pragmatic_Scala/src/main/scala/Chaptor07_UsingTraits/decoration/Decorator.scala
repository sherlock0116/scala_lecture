package Chaptor07_UsingTraits.decoration

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Decorator {}

abstract class Check {
	def check(): String = "Checked Application Details ."
}

trait CreditCheck extends Check {
	override def check(): String = s"Checked Credit... ${super.check()}"
}

trait EmploymentCheck extends Check {
	override def check(): String = s"Checked Employment... ${super.check()}"
}

trait CriminalRecordCheck extends Check {
	override def check(): String = s"Checked Criminal Records... ${super.check()}"
}

object Decorator extends App {
	
	val apartmentCheck: Check with CreditCheck with EmploymentCheck = new Check with CreditCheck with EmploymentCheck
	val employmentCheck: Check with EmploymentCheck with CriminalRecordCheck = new Check with EmploymentCheck with CriminalRecordCheck
	
	println(apartmentCheck.check())
	println(employmentCheck.check())
}