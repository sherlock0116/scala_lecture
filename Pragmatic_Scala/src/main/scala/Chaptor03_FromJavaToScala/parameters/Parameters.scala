package Chaptor03_FromJavaToScala.parameters

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Parameters {
	
	def max(values: Int*): Int = values.foldLeft(values(0)) {Math.max}
	
	def main(args: Array[String]): Unit = {
		println(max(2, 1, 0, 23, 34, 12, 21, 99))
	}
}
