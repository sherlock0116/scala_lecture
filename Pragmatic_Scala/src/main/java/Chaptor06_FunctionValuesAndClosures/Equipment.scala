package Chaptor06_FunctionValuesAndClosures

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Equipment(val routine: Int => Int) {
	
	def simulate(input: Int): Int = {
		println("Running simulation...")
		routine(input)
	}
}

object Equipment extends App {
	
	val caculator = {input: Int => println(s"calc with $input"); input}
	
	val eq1: Equipment = new Equipment(
		{ input => println(s"calc with $input"); input }
	)
	val eq2: Equipment = new Equipment(caculator)
	
	eq1.simulate(5)
	eq2.simulate(7)
}