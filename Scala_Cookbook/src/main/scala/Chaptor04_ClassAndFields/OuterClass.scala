package Chaptor04_ClassAndFields

import Chaptor04_ClassAndFields.TestClassInObject.{oc1, oc2}

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class OuterClass {
	class InnerClass {
		var x = 1
	}
}

object TestClassInObject extends App {
	
	val oc1: OuterClass = new OuterClass
	val oc2: OuterClass = new OuterClass
	
	val ic1: oc1.InnerClass = new oc1.InnerClass
	val ic2: oc2.InnerClass = new oc2.InnerClass
	
	ic1.x = 10
	ic2.x = 20
	
	println(s"ic1.x = ${ic1.x}")
	println(s"ic2.x = ${ic2.x}")
}
