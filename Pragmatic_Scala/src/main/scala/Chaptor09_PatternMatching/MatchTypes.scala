package Chaptor09_PatternMatching

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object MatchTypes {
	
	def process(input: Any): Unit = {
		input match {
			case (_: Int, _: Int) =>
				println("Processing (Int, Int) ......")
			case (_: Double, _: Double) =>
				println("Processing (Double, Double) ......")
			case msg: Int if msg > 10000 =>
				println("Processing Int > 10000")
			case _: Int =>
				println("Processing Int ......")
			case _: String =>
				println("Processing String ......")
			case _ =>
				println(s"Can't handle $input ......")
		}
	}
	
	def main(args: Array[String]): Unit = {
		
		process((34.2, -125.5))
		process(0)
		process(12345)
		process(2.2D)
		
	}
}
