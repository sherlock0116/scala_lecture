package Chaptor03_FromJavaToScala.primitive

import java.util

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class ScalaInt {
	
	def playWithInt(): Unit = {
		val capacity: Int = 10
		val list: util.ArrayList[String] = new java.util.ArrayList[String]
		list.ensureCapacity(capacity)
	}
}

