package Chaptor06_FunctionValuesAndClosures

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Inject1 {
	
	def totalResuktOverRange(num: Int, codeBlock: Int => Int): Int = {
		var rel: Int = 0
		for (i <- 1 to num) {
			rel = rel + codeBlock(i)
		}
		rel
	}
	
	def main(args: Array[String]): Unit = {
		
		// 总和
		println(totalResuktOverRange(10, i => i))
		// 偶数个数
		println(totalResuktOverRange(21, i => if (i % 2 == 0) 1 else 0))
		// 偶数和
		println(totalResuktOverRange(21, i => if (i %2 == 0) i else 0))
	}
}
