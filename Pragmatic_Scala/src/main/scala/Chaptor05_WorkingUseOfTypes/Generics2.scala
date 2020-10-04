package Chaptor05_WorkingUseOfTypes

import java.util

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Generics2 {
	
	var list1 = new util.ArrayList[Int]
	var list2 = new util.ArrayList[Any]
	
	var ref1: Int = 1
	var ref2: Any = _
	
	// 编译正确
	ref2 = ref1
	// 编译错误
//	list2 = list1


}
