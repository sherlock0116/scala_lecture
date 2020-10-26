package Chaptor01_String

import scala.reflect.internal.util.StringOps
import scala.util.matching.Regex

/**
 * @Description
 * @Author sherlock
 * @Date
 */
object String_Demo{
	
	val hello: String = "Hello"
	
	def main(args: Array[String]): Unit = {
		
		//H,e,l,l,o
		println(
			hello.split("").mkString(",")
		)
		
		// H e l l o
		hello.foreach(s => print(s"$s "))
		
		// H e l l o
		for (s <- hello) print(s"$s ")
		
		// 72 101 108 108 111
		hello.getBytes.foreach(b => print(s"$b "))
		
		// Ll, capitalize 方法返回首字母大写的字符串
		println(hello.slice(2, 4).capitalize)
		
		
		val str1 = "miao"
		val str2 = "Miao"
		println(str1 == str2)	// false
		println(str1.toLowerCase == str2.toLowerCase)	// true
		println(str1 equalsIgnoreCase str2)						// true
		
		val a1 = new Animal("cat")
		val a2 = new Animal("cat")
		println(a1 == a2)		// true, ==比较的是值
		println(a1 eq a2)		// false, eq 比价的是地址
		
		/*
		 * This is a love story!
		 * 	Taylor Swift
		 */
		val multiStr1 =
			"""This is a love story!
			  |	Taylor Swift
			  |""".stripMargin
		println(multiStr1)
		
		/*
		 * This is a love story!
		 * 	Taylor Swift
		 */
		val multiStr2 =
			"""This is a love story!
	   		  #	Taylor Swift
			  #""".stripMargin('#')
		println(multiStr2)
		
		val multiStr3 =
			"""This is a love story!
			  |Taylor Swift
			  |""".stripMargin.replaceAll("\n", " ")
		println(multiStr3)
		
		/*
		 * This is known as a "multiline" string or 'heredoc' syntax.
		 */
		val multiStr4 =
			"""This is known as a
			  |"multiline" string
			  |or 'heredoc' syntax.
			  |""".stripMargin.replaceAll("\n", " ")
		println(multiStr4)
		
		// Hello|world,|this|is|scala
		println(
			"Hello world, this is scala".split("\\s+").map(_.trim).mkString("|")
		)
		// Hello|world,|this|is|scala
		println(
			"Hello world, this is scala".split(" ").map(_.trim).mkString("|")
		)
		
		
		/**
		 * s: 引用变量
		 * f: 格式化浮点数
		 * raw: 将转义符当做字符串输出
		 */
		val price = 6.3
		// this shirt's price is $6.30
		println(f"this shirt's price is $$$price%.2f \n")
		// this shirt's price is $6
		println(f"this shirt's price is $$$price%.0f \n")
		// this shirt's price is $6.3\n
		println(raw"this shirt's price is $$$price\n")
		
		
		/**
		 * for/yield == map
		 */
		// HELLO
		println(hello.map(_.toUpper))
		val t1 = for (e <- hello) yield e.toUpper
		// HELLO
		println(t1)
		
		/**
		 * 1.6 字符串的查找模式
		 *
		 * 在正则中，表示次数的量词默认是贪婪的，在贪婪模式下，会尝试尽可能最大长度去匹配
		 * 那么如何将贪婪模式变成非贪婪模式呢？我们可以在量词后面加上英文的问号 (?)
		 */
		val numPattern = "[0-9]+".r
		val address = "123 Main Street Suite 101"
		
		// 123
		val option: Option[String] = numPattern.findFirstIn(address)
		println(option.getOrElse("no match"))
		// 123|101
		val iterator: Regex.MatchIterator = numPattern.findAllIn(address)
		println(iterator.mkString("|"))
		
		val p1 = "a+".r			// 默认贪婪模式, 尽可能匹配最长的 a, [aaa]
		val p2 = "a*".r			// 默认贪婪模式, 尽可能匹配最长的 a, [aaa, , , ]
		val p3 = "a*?".r		// 非贪婪模式,
		val p4 = "a+?".r		// 非贪婪模式,
		val p5 = "a++".r		// 独占模式,
		val nums = "aaabb"
		// aaa
		println(p1.findAllIn(nums).mkString(", "))
		// aaa, , ,
		println(p2.findAllIn(nums).mkString(", "))
		// , , , , ,
		println(p3.findAllIn(nums).mkString(", "))
		// a, a, a
		println(p4.findAllIn(nums).mkString(", "))
		// aaa
		println(p5.findAllIn(nums).mkString(", "))
		
		val sentence =
			""""The little cat" is a toy,
			  | it looks "a little bad"
			  |""".stripMargin.replaceAll("\n", " ")
		val p11 = "\".+\"".r	// 贪婪模式会尽最大长度匹配双引号之间的内容
		val p12 = "\".+?\"".r	// 非贪婪模式会匹配双引号之间的最小长度的内容
		// "The little cat" is a toy,  it looks "a little bad"
		println(p11.findAllIn(sentence).mkString("|"))
		// "The little cat"|"a little bad"
		println(p12.findAllIn(sentence).mkString("|"))
		
		val pattern = "([0-9]+) ([a-zA-Z]+)".r
		val pattern(count, fruit) = "100 bananas"
		// count: 100, fruit: bananas
		println(s"count: $count, fruit: $fruit")
		
		/**
		 * 1.9 访问字符串中一个字符
		 * 把 String 看成 Char[] 数组
		 */
		println( hello.charAt(2) ) 	// l
		println( hello(2) ) 				// l
		
		/**
		 * 1.10 在 String 类中添加自定义的方法, 类似 "hello".increment
		 *
		 * 	利用隐式转换类:
		 * 		一个隐式转换类必须定义在一个类/对象/包的内部.
		 *
		 */
		
		// (1). 隐式类定义在伴生对象中, 详见 ImplicitsInObject
		// import ImplicitsInObject._
		
		// (2). 隐式类定义在包对象中, 详见 package
		// 在包对象所对应的包下的所有类都可以使用该包对象下的所有方法, 所以这里的 increment, 用的是 package object Chaptor01_String 中的 increment
		println("HAL".increment)
		
		
	}
	
	case class Animal(name: String)
}

