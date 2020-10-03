package cgs.scala.parameters

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Parameters {
	
	def main(args: Array[String]): Unit = {
		println(max(2, 3, 4, 1, 34, 5))
	}
	
	def max(values: Int*) = values.foldLeft(values(0)) {Math.max}
}
