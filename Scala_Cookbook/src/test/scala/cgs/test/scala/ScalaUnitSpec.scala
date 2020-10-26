package cgs.test.scala

import java.util

import cgs.test.UnitSpec

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class ScalaUnitSpec extends UnitSpec{
	
	describe("泛型擦除") {
		it ("should equals") {
			
			val list1 = new util.ArrayList[String]()
			val list2 = new util.ArrayList[Integer]()
			println(list1.getClass)
			assert(list1.getClass == list2.getClass)
		}
	}
}
