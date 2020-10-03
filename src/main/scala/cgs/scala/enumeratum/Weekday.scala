package cgs.scala.enumeratum

import enumeratum._

import scala.collection.immutable

/**
 * Descriptor: enumeratum 是 Scala 的类型安全且功能强大的枚举实现，可提供详尽的模式匹配警告。
 *
 * 	除了详尽的模式匹配警告外，枚举还提供：
 * 			1. 列出可能的值（因为需要在Enum继承上实现值）
 * 			2. 默认的序列化/反序列化方法（有无异常）
 * 			3. 为枚举添加额外的值。 这非常类似于我们如何使用简单的密封案例对象添加额外的值
 * 			4. 可以采用与密封层次结构相同的方式来实现排序。 只需混合使用Ordered []特性并实现compare方法。
 *
 * Author: sherlock
 */
sealed abstract class Weekday(val name: String,
							  val abbreviation: String,
							  val isWorkDay: Boolean,
							  val order: Int) extends EnumEntry with Ordered[Weekday] {

	def compare(that: Weekday): Int = this.order - that.order
}

object Weekday extends Enum[Weekday] {
	val values: immutable.IndexedSeq[Weekday] = findValues // mandatory due to Enum extension

	case object Monday extends Weekday("Monday", "Mo.", true, 2)
	case object Tuesday extends Weekday("Tuesday", "Tu.", true, 3)
	case object Wednesday extends Weekday("Wednesday", "We.", true, 4)
	case object Thursday extends Weekday("Thursday", "Th.", true, 5)
	case object Friday extends Weekday("Friday", "Fr.", true, 6)
	case object Saturday extends Weekday("Saturday", "Sa.", false, 7)
	case object Sunday extends Weekday("Sunday", "Su.", false, 1)

	def test(weekday: Weekday): Unit = {
		weekday match {
			case Weekday.Monday => println("I hate Mondays")
			case Weekday.Sunday => println("The weekend is already over? :( ")
		}
	}

	def main(args: Array[String]): Unit = {

		println(Weekday.withName("Monday")) 	// Monday
		println(Weekday.values)												// Vector(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)
		println(Weekday.indexOf(Sunday))							// 6
		Weekday.values.filter(_.isWorkDay).foreach(e => print(s"${e} "))		//Monday Tuesday Wednesday Thursday Friday
	}
}
