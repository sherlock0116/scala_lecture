/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
package object Chaptor02_Num {
	
	/**
	 * Scala 中所有数值都是对象, 包括 Byte, Char, Double, Float, Int, Long, Short
	 * 它们与被称为"非数值类型"的 Unit 和 Boolean 一样, 这些数值类型都继承扩展自AnyVal 特质
	 *
	 * 内建数值类型的数值范围 (8bit = 1byte)
	 * Char			16位无符号 Unicode 字符
	 * Byte		8 位有符号整数
	 * Short		16 位有符号整数
	 * Int			34 位有符号整数
	 * Long			64 位有符号整数
	 * Float		32 位 IEEE 754 单精度浮点数
	 * Double		64 位 IEEE 754 双精度浮点数
	 *
	 * 复数和日期类型
	 * 除了 scala 自带的 math 类库, 如果需要更加强大的数学运算能力
	 * 可以了解一下 Spire (https://github.com/non/spire) 以及
	 * ScalaLab (https://code.google.com/p/scalalab)
	 *
	 * 关于日期的处理, Scala 的 nscala-time (http://github.com/nscala-time/nscala-time)
	 * 对 Joda Time 进行了封装, 可以写出更具有 Scala 风格的日期表达式
	 */
	
	
	implicit class StringToInt(val s: String) {
		
		@throws(classOf[NumberFormatException])
		def toInt(radix: Int): Int = Integer.parseInt(s, radix)
	}
}
