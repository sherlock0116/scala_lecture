package Chaptor06_FunctionValuesAndClosures

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Inject2 {
	
	def printValue(generator: () => Int): Unit = {
		println(s"Generated value is ${generator()}")
	}
	
	def inject(array: Array[Int], initial: Int, operation: (Int, Int) => Int): Int = {
		var carryOver: Int = initial
		array.foreach(e => carryOver = operation(carryOver, e))
		carryOver
	}
	
	def main(args: Array[String]): Unit = {
		printValue(() => 99)
		
		val arr: Array[Int] = Array(2, 3, 5, 1, 6, 4)
		val sum: Int = inject(arr, 0, (carray, e) => carray + e)
		println(s"Sum of elements in array is $sum")
		
		val max: Int = inject(arr, Int.MinValue, (carry, e) => math.max(carry, e))
		println(s"Max of elements in array is $max")
		
		// 使用 foldLeft 代替 inject
		val sum_ : Int = arr.foldLeft(0)((sum, e) => sum + e) // 等同于 arr.sum
		val max_ : Int = arr.foldLeft(Int.MinValue)((max, e) => math.max(max, e)) // 可以简写为 arr.foldLeft(Int.MinValue){math.max}
		println(s"Sum_ of elements in array is $sum_")
		println(s"Max_ of elements in array is $max_")
		
		// 在 Scala 中 foldLeft 可以等效为 /: 操作符
		val sum__ : Int = (0 /: arr)((sum, e) => sum + e)
		val max__ : Int = (Int.MinValue /: arr) { (max, e) => math.max(max, e) }
		println(s"Sum__ of elements in array is $sum__")
		println(s"Max__ of elements in array is $max__")
	}
}
