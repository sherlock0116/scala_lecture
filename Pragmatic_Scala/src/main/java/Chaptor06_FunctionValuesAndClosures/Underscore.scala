package Chaptor06_FunctionValuesAndClosures

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Underscore extends App {
	
	val array = Array(2, 4, 5, 8, 3)
	val sum = (0 /: array) {_ + _}
	println(s"Sum of elements in array is $sum")
	
	val negativeNumExist1 = array.exists(e => e < 0)
	val negativeNumExist2 = array.exists(_ < 0)
	
	val largest = (Int.MinValue /: array) {(max, e) => math.max(max, e)}
	val largest_ = (Int.MinValue /: array) {math.max(_, _)}
	val largest__ =  (Int.MinValue /: array) {math.max _}
	val largest___ =  (Int.MinValue /: array) {math.max}
}
