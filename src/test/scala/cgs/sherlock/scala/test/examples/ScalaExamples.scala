package cgs.sherlock.scala.test.examples

import org.scalatest.funsuite.AnyFunSuite

import scala.util.Sorting

/**
 * Descriptor:
 * Author: sherlock
 */
class ScalaExamples extends AnyFunSuite{

	test("scala 阶乘") {
		val num = 20
		def factorial(x: BigInt): BigInt = {
			if (x == 0) 1 else x * factorial(x - 1)
		}
		println(s"${num}! = ${factorial(num)}")
	}

	test("scala 快排, 不是尾递归, 开销较大") {
		def qSort[T <% Ordered[T]](list: List[T]): List[T] = {
			if (list.length < 2) list
			else qSort(list.filter(_ < list.head)) ++
					list.filter(_ == list.head) ++
					qSort(list.filter(_ > list.head))
		}

		val list = List(10, 5, 34, 10, 56, 3, 1, 8, 23)
		println(qSort(list))
	}

	test("scala 自带的快排方法") {
		val arr = Array(10, 5, 34, 10, 56, 3, 1, 8, 23)
		Sorting.quickSort(arr)
		arr.foreach(e => print(s"${e} "))
	}


}
