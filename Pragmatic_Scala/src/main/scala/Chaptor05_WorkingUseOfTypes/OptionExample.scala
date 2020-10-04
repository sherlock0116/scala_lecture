package Chaptor05_WorkingUseOfTypes

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object OptionExample {
	
	def commentOnPractice(input: String) = {
		if (input == "test")
			Some("good")
		else
			None
	}
	
	def main(args: Array[String]): Unit = {
		
		for (in <- Set("test", "hack")) {
			val maybeString: Option[String] = commentOnPractice(in)
			val str: String = maybeString.getOrElse("Found no comment")
			println(s"input: $in,  comment: $str")
		}
	}
}
