package Chaptor03_control

import scala.annotation.switch
import scala.util.control.Breaks
import scala.util.control.Breaks.{break, breakable}

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object BreakAndContinue_Demo extends App {

	println("\n======== BREAK EXAMPLE ========")
	
	breakable{
		for (i <- 1 to 10) {
			println(i)
			if (i > 4) break // break out of the for loop
		}
	}
	
	println("\n======== CONTINUE EXAMPLE ========")
	val searchMe = "peter piper picked a peck of pickled peppers"
	var numPs = 0
	for (i <- 0 until searchMe.length) {
		breakable {
			if (searchMe(i) != 'p') {
				break
			} else {
				numPs += 1
			}
		}
	}
	println(s"Found $numPs p's in the string")
	
	val inner = new Breaks
	val outer = new Breaks
	
	outer.breakable {
		for (i <- 1 to 5)
			inner.breakable{
				for (j <- 'a' to 'e') {
					if (i == 1 && j == 'c') inner.break else println(s"i:$i, j:$j")
					if (i == 2 && j == 'b') outer.break else println(s"i:$i, j:$j")
				}
			}
	}
	
	/**
	 * 像使用三元运算符一样使用 if
	 * 因为 if/else 有返回值, 所以可以把它嵌入到打印语句中
	 */
	val num = 10
	println(if (num >= 0) num else -num)
	
	/**
	 * 建议在使用 switch 的时候对变量添上@switch 注解
	 * 因为使用该注解时, 如果 switch 语句不能被编译为 tableswitch 或者 lookupswitch 时, 注解会引发编译警告
	 * 将匹配表达式编译为 tableswitch 或者 lookupswitch 的性能会更好, 因为它会生成分支表而不是决策树.
	 * 但是该用法局限性很大:
	 * 			1. 匹配的值一定是一个已知的整数
	 * 			2. 匹配的表达式, 既不能包含任何的类型检测, if 语句或者抽取器
	 * 			3. 保证表达式在编译时值可用
	 * 			4. 至少包含两个 case 语句
	 */
	val ii = 5
	val month: String = (ii: @switch) match {
		case 1 => "January"
		case 2 => "February"
		case 3 => "March"
		case 4 => "April"
		case 5 => "May"
		case 6 => "June"
		case 7 => "July"
		case 8 => "Auguest"
		case 9 => "September"
		case 10 => "October"
		case 11 => "November"
		case 12 => "December"
		case _ => "Invalid month"
	}
	
	def eachWhatYouGaveMe(x: Any): String = x match {
		case 0 => "Zero"
		case true => "true"
		case "hello" => "you said hello"
		case Nil => "a empty List"
			// sequence pattern
		case List(0, _, _) => "a three-element list with 0 as the first element"
		case List(1, _*) => "a list beginning with 1, having any number of elements"
		case Vector(1, _*) => "a vector beginning with 1, having any number of elements"
			// tuples
		case (a, b) => s"got $a and $b"
		case (a, b, c) => s"got $a , $b and $c"
			// constructor patterns
		case Person(first, "Alexander") => s"found an Alexander, first name is $first"
		case Dog("Suka") => "found a dog named Suka"
			//typed patterns
		case s: String => s"you gave me this string: ${s}"
		case i: Int => s"thanks for the Int: $i"
		case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
		case as: Array[String] => s"an arry of strings: ${as.mkString(",")}"
		case d: Dog => s"dog: ${d.name}"
		case m: Map[_, _] => m.toString()
		case default => s"unknow ${default}"
	}
	
	/**
	 * 给模式添加变量
	 */
	def matchType(x: Any) = x match {
//		case x: List(1, _*) => s"$x"			// can't compile
		case x @ List(1, _*) => s"${x}"
		case List(2, other @ _*) => s"${other.mkString(",")}"
		case Some(_) => "Got a Some"		// works, but can't access the Some
		case Some(x) => s"$x"					// works, return "foo"
		case x @ Some(_) => s"${x}"			// works, return "Some(foo)"
		
	}
	
	case class Person(firstName: String, lastName: String)
	case class Dog(name: String)
}
