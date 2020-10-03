package Chaptor05_WorkingUseOfTypes

import java.util

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Generics extends App {
	
	var list1 = new util.ArrayList[Int]
	var list2 = new util.ArrayList
	
	// 编译期就会报错, 因为 list2 是 ArrayList[Nothing] 类型
//	list1 = list2
}
