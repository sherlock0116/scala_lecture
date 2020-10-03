package Chaptor09_PatternMatching

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */

class MatchWithField {
	
	val max: Int = 100
	
	def process(input: Any):Unit = {
		input match {
//			case max => println(s"You matched max $max")
			case `max` => println(s"You matched max $max")
		}
	}
	
}

object MatchWithField extends App {
	
	val matchWithField: MatchWithField = new MatchWithField
	
	try {
		matchWithField.process(0)
	} catch {
		case e: Throwable => println(e)
	}
	
	matchWithField.process(100)
}