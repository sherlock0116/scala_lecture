package Chaptor05_WorkingUseOfTypes

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object EitherExample {
	
	def compute(in: Int) = {
		if (in > 0)
			Right(math.sqrt(in))
		else
			Left(s"Error compute, invalid input: $in")
	}
	
	def displayResult(relsult: Either[String, Double]): Unit = {
		println(s"Raw: $relsult")
		
		relsult match {
			case Left(err) => println(s"Error: $err")
			case Right(num) => println(s"Result: $num")
		}
	}
	
	def main(args: Array[String]): Unit = {
		
		displayResult(compute(4))
		displayResult(compute(-4))
	}
	
}
