package cgs.sherlock.scala.test.collection

import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable.ListBuffer

/**
 * Descriptor:
 * Author: sherlock
 */
class ScalaListBuffer extends AnyFunSuite{

	test(":+会产生新的List, +=只是往原集合中添加元素") {
		val lb1 = ListBuffer(1, 2, 3, "cat")
		val lb2 = lb1 :+ "dog"
		lb1 += "ragdoll" // 也可以使用append
		lb1.foreach(e => print(s"${e} "))
		println()
		lb2.foreach(e => print(s"${e} "))
	}

	test("++=") {
		val lb1: ListBuffer[Any] = ListBuffer(1, 2, 3)
		val lb2 = ListBuffer("a", "b", "c")
		lb1 ++= lb2
		lb1.foreach(e => print(s"${e} "))
	}
}
