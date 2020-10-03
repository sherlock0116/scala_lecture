package Chaptor05_WorkingUseOfTypes.interpolator

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object MyInterpolator {
	
	implicit class Interpolator(val sc: StringContext) extends AnyVal {
		
		def mask(args: Any*): StringBuilder = {
			val processed: String = sc.parts.zip(args).map { item =>
				val (text, expression) = item
				if (text.endsWith("^"))
					s"${text.split('^')(0)}${expression}"
				else
					s"$text....${expression.toString takeRight 4} (only last four numbers)"
			}.mkString
			new StringBuilder(processed).append(sc.parts.last)
		}
	}
}
