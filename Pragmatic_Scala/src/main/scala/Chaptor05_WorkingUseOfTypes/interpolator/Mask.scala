package Chaptor05_WorkingUseOfTypes.interpolator

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Mask extends App {
	
	import MyInterpolator._
	
	val ssn = "123-45-6789"
	val acc = "02467234"
	val balance = 20145.23
	
	println(
		mask"""
		  |Account:$acc
		  |Social Security Number:$ssn
		  |Balanace:$$^$balance
		  |Thank you for your business.
		  |""".stripMargin)
}
