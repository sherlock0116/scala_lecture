package Chaptor05_WorkingUseOfTypes

/**
 * @Description
 *             定义变量并显式其类型
 * @Author sherlock
 * @Date
 */
object DefiningVariable extends App {
	
	// 定义变量并显式其类型
	val greet1: String = "Ahoy !"
	// 定义变量使用类型推断
	val greet2 = "Ahoy !"
	
	println(s"greet1: ${greet1.getClass}")
	println(s"greet2: ${greet2.getClass}")
}
