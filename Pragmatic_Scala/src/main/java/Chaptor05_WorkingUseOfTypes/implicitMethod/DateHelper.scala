package Chaptor05_WorkingUseOfTypes.implicitMethod

import java.time.LocalDate

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class DateHelper(offset: Int) {
	
	def days(when: String): LocalDate = {
		val today: LocalDate = LocalDate.now()
		when.toLowerCase match {
			case "ago" => today.minusDays(offset)
			case "from_now" => today.plusDays(offset)
			case _ => today
		}
	}
}

object DateHelper {
	val ago: String = "ago"
	val from_now: String = "from_now"
	implicit def convertInt2DateHelper(offset: Int): DateHelper = new DateHelper(offset)
}
