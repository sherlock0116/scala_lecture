package Chaptor09_PatternMatching


/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Wildcard {

	def activity(day: DayOfWeek.Value): Unit = {
		day match {
			case DayOfWeek.SUNDAY =>
				println("eat, sleep, repeat......")
			case DayOfWeek.SATURDAY =>
				println("hang out with gf")
			case _ =>
				println("working day......")
		}
		
	}
	
	def main(args: Array[String]): Unit = {
		
		activity(DayOfWeek.SATURDAY)
		
	}

}

object DayOfWeek extends Enumeration {
	
	val SUNDAY: DayOfWeek.Value = Value("Sunday")
	val MONDAY: DayOfWeek.Value = Value("Monday")
	val TUESDAY: DayOfWeek.Value = Value("Tuesday")
	val WEDNESDAY: DayOfWeek.Value = Value("Wednesday")
	val THURSDAY: DayOfWeek.Value = Value("Thursday")
	val FRIDAY: DayOfWeek.Value = Value("Friday")
	val SATURDAY: DayOfWeek.Value = Value("Saturday")
	
}
