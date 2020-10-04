package Part01_Introduction_of_functional_programming.Getting_started

import scala.annotation.tailrec

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object MyModule {
	
	def abs(n: Int): Int = {
		if (n < 0) -n
		else n
	}
	
	/**
	 * 遍历数组中第一个值为 key 的元素下标
	 * @param ss 目标数组
	 * @param key 目标值
	 * @return 数组下标索引
	 */
	def findFirst(ss: Array[String], key: String): Int = {
		
		@tailrec
		def loop(n: Int): Int = {
			if (n >= ss.length) -1
			else if (ss(n) == key) n
			else loop(n +1)
		}
		loop(0)
	}
	
	/**
	 * 该方法作用同上, 引入泛型 T, 可以使用于任何类型的数组
	 * @param ss  目标数组
	 * @param f    查找条件
	 * @tparam T 数组泛型
	 * @return      数组下标
	 */
	def findFirst[T](ss: Array[T], f: T => Boolean): Int = {
		
		@tailrec
		def loop(n: Int): Int = {
			if (n >= ss.length) -1
			else if (f(ss(n))) n
			else loop(n + 1)
		}
		loop(0)
	}
	
	def isSorted[T](as: Array[T], ordered: (T, T) => Boolean): Boolean = {
		
		@tailrec
		def loop(n: Int): Boolean = {
			if (n >= as.length - 1) true
			else if (!ordered(as(n), as(n + 1))) false
			else loop(n + 1)
		}
		loop(0)
	}
}
