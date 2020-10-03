package Chaptor06_FunctionValuesAndClosures

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object inject3 {
	
	def inject(array: Array[Int], initial: Int)(operation: (Int, Int) => Int): Int = {
		var carryOver: Int = initial
		array.foreach(e => carryOver = operation(carryOver, e))
		carryOver
	}
	
	def main(args: Array[String]): Unit = {
		
		val arr: Array[Int] = Array(2, 3, 5, 1, 6, 4)
		
		val sum: Int = inject(arr, 0) {
			(carry, e) => carry + e
		}
	}
}
