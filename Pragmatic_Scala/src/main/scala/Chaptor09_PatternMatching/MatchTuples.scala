package Chaptor09_PatternMatching

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object MatchTuples {
	
	def processCoordinates(input: Any): Unit = {
		input match {
			case (lat, long) => println(s"Processing ($lat, $long)")
			case "done" => println("done")
			case _ => println("invalid input")
		}
	}
	
	def main(args: Array[String]): Unit = {
		
		processCoordinates((23, -123))
		processCoordinates("done")
	}
}
