package Chaptor02_Num

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Number_Demo {
	
	def main(args: Array[String]): Unit = {
		
		/**
		 * 2.2 数值类型转换
		 */
		// 使用十进制以外的计算, 参数一表示某进制下的数, 参数二表示进制数, 返回结果为十进制数
		println(Integer.parseInt("12AF", 16))
		println("3417".toInt(8))
		println("100101".toInt(2))
		
		// 数值转换前可以进行转换检查(String 没有这种方式)
		// isValidByte/isValidShort
		println(1000L.isValidInt)
		println(100.isValidLong)
		println('A'.isValidByte)
		println('B'.isValidChar)
		
		/**
		 * 2.5 浮点数的比较
		 *
		 * scala> val a = 0.3
		 * a: Double = 0.3
		 *
		 * scala> val b = 0.1 + 0.2
		 * b: Double = 0.30000000000000004
		 *
		 * scala> a == b
		 * res0: Boolean = false
		 */
		// 不知道为什么这里居然 0.3 == 0.1 + 0.2, 在 Scala REPL中是不相等的.
		val a: Double = 0.5
		val b: Double = 0.2 + 0.3
		println(s"a=$a, b=$b, a==b: ${a==b}") // false
		
		
		
		
	}
}
