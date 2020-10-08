package Part01_Introduction_of_functional_programming

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object MyModule {
	
	/**
	 * 求绝对值
	 * @param n 目标数
	 * @return   目标数的绝对值
	 */
	def abs(n: Int): Int = {
		if (n < 0) -n
		else n
	}
	
	/**
	 * Scala 中的尾调用是指调用者在一个递归调用之后不做其他事, 只是返回这个调用结果.
	 * @param n 目标阶乘
	 * @return
	 */
	def factorial(n: Int): Int = {
		@annotation.tailrec
		def go(n: Int, acc: Int): Int = {
			if (n < 0) throw new IllegalArgumentException
			else if (n == 0) acc
			else go(n - 1, n * acc)		// 这就是一个尾调用
		}
		go(n, 1)
	}
	
	/**
	 *
	 * @param n
	 * @return
	 */
	def fib(n: Int): Int = {
		@annotation.tailrec
		def loop(n: Int, pre: Int, cur: Int): Int = {
			if (n == 0) pre
			else loop(n - 1, cur, pre + cur)
		}
		loop(n, 0, 1)
	}
	
	/**
	 * 返回数组中第一个匹配到 key 的索引
	 * @param as   目标数组
	 * @param key 目标 key
	 * @return		 索引
	 */
	def findFirst(as: Array[String], key: String): Int = {
		
		@annotation.tailrec
		def loop(n: Int): Int = {
			if (n >= as.length) -1
			else if (as(n) == key) n
			else loop(n + 1)
		}
		loop(0)
	}
	
	def formatAbs(x: Int): String = {
		s"The absolute value of $x is ${abs(x)}"
	}
	
	def formatFactorial(n: Int): String = {
		s"The factorial of $n is ${factorial(n)}"
	}
	
	
	
	
	
	def main(args: Array[String]): Unit = {
		
		println(formatAbs(-21))
		
		println(formatFactorial(5))
		
//		(0 to 10).foreach(x => println(s"第${x} 个斐波那契数是: [${fib(x)}]"))
	
	}
}
