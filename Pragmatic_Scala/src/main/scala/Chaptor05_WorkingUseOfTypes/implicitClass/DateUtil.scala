package Chaptor05_WorkingUseOfTypes.implicitClass

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object DateUtil {
	
	val ago: String = "ago"
	val from_now: String = "from_now"
	
	implicit class DateHelper(val offset: Int) extends AnyVal {
		import java.time.LocalDate
		
		def days(when: String): LocalDate = {
			val today: LocalDate = LocalDate.now()
			when.toLowerCase match {
				case "ago" => today.minusDays(offset)
				case "from_now" => today.plusDays(offset)
				case _ => today
			}
		}
	}
}
