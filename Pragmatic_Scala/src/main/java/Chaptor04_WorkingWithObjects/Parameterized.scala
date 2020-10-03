package Chaptor04_WorkingWithObjects

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Parameterized {
	
	def echo[T](input1: T, input2: T): Unit = {
		println(s"got $input1(${input1.getClass}) $input2(${input2.getClass})")
	}
	
	def echo2[T, V](input1: T, input2: V): Unit = {
		println(s"got $input1(${input1.getClass}) $input2(${input2.getClass})")
	}
}

object Parameterized extends App {
	val parameterized: Parameterized = new Parameterized
	parameterized.echo("hello", "scala")
	parameterized.echo(4, 5)
	
	parameterized.echo("miao", 4L)
	
	// 编译报错
//	parameterized.echo[String]("mi", 7)
	
	parameterized.echo2("hi", 5.5)
}
