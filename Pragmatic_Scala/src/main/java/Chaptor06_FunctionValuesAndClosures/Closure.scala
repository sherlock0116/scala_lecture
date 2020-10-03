package Chaptor06_FunctionValuesAndClosures

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Closure {
	
	def loopThrough(num: Int)(closure: Int => Unit): Unit = {
		for (i <- 1 to num) closure(i)
	}
	
	var result: Int = 0
	val addIt: Int => Unit = { e: Int => result += e}
	
	def main(args: Array[String]): Unit = {
		
		loopThrough(10) {elem => addIt(elem)}
		println(s"Total of values from 1 to 10 is $result")
		
		result = 0
		loopThrough(5) {addIt}
		println(s"Total of values from 1 to 5 is $result")
		
		var product: Int = 1
		loopThrough(5) {product *= _}
		println(s"Product of values from 1 to 5 is $product")
		
		product = 1
		loopThrough(10) {product *= _}
		println(s"Product of values from 1 to 10 is $product")
	}
}
