package cgs.scala.`enum`

import com.sun.tools.corba.se.idl.EnumEntry


/**
 * Descriptor: Scala 的枚举 Enumeration
 *
 * 	Enumeration 的局限性:
 * 					1. Scala 的 Enumeration 仅仅提供索引和名称
 * 					2. Mon, Tue, ...... 在类型擦除后都是 Enumeration#Value 类型, 定义方法时可能会报错
 * 	替代方案:
 * 					1. sealed case objects
 * 					2. itemized
 * 					3. enumeratum
 *
 * 	sealed case objects:
 * 			1. 没有简单的方法来检索所有枚举值
 * 			2. 没有默认的序列化/反序列化方法
 * 			3. 枚举值之间没有默认的排序-这可以通过手动添加来实现
 *
 * 	itemized :
 *
 * 	enumeratum: 详见 cgs.scala.enumeratum.Weekday
 *
 *
 * Author: sherlock
 */
object WeekDay extends Enumeration {

	type WeekDay = Value
	val Mon = Value(1, "周一")
	val Tue = Value(2, "周二")
	val Wed = Value(3, "周三")
	val Thu = Value(4, "周四")
	val Fri = Value(5, "周五")
	val Sat = Value(6, "周六")
	val Sun = Value(7, "周日")

	def checkExists(day: Int) = {
		this.values.exists(_.id == day)
	}

}

object OtherEnum extends Enumeration {
	val A, B, C = Value
}

object TestEnum {

	/*
	这样定义就会报错, 因为 擦除后，枚举具有相同的类型 Enumeration#Value 。
	def test(enum: WeekDay.Value) = {
		println(s"enum: $enum")
	}
	def test(enum: OtherEnum.Value) = {
		println(s"enum: $enum")
	}
	*/

}


 sealed abstract class Weekday(
									  val name: String,
									  val abbreviation: String,
									  val isWorkDay: Boolean,
									  val order: Int) extends Ordered[Weekday] {

	 def compare(that: Weekday) = this.order - that.order

	 case object Monday extends Weekday("Monday", "Mo.", true, 2)
	 case object Tuesday extends Weekday("Tuesday", "Tu.", true, 3)
	 case object Wednesday extends Weekday("Wednesday", "We.", true, 4)
	 case object Thursday extends Weekday("Thursday", "Th.", true, 5)
	 case object Friday extends Weekday("Friday", "Fr.", true, 6)
	 case object Saturday extends Weekday("Saturday", "Sa.", false, 7)
	 case object Sunday extends Weekday("Sunday", "Su.", false, 1)

	 def test(weekday: Weekday) = {
		 weekday match {
			 case Monday => println("I hate Mondays")
			 case Sunday => println("The weekend is already over? :( ")
		 }
	 }
 }



