package Part01_Introduction_of_functional_programming.Getting_started

import scala.annotation.tailrec

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object TailRecursion {
	
	def fib(n: Int): Int = {
		
		@tailrec
		def loop(n: Int, pre: Int, cur: Int): Int = {
			if (n < 0) throw new IllegalArgumentException
			else if (n == 0) pre
			else loop(n - 1, cur, pre + cur)
		}
		loop(n, 0, 1)
	}
	
	def main(args: Array[String]): Unit = {
		
		(1 to 10).foreach(n => {
			println(s"第 ${n} 个斐波那契数是: \t[${fib(n)}]")
		})
	}
}
