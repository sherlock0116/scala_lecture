package Chaptor09_PatternMatching

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object MatchLiterals extends App {
	
	def activity(day: String): Unit = {
		day.toLowerCase match {
			case "sunday" => println("Eat, Sleep, Repeat......")
			case "saturday" => println("Hang out with gf")
			case "monday" => println("... code for fun ...")
			case "friday" => println("... read a good book ...")
		}
	}
	
	List("Monday", "Sunday", "Saturday").foreach(activity)
	
	
}

