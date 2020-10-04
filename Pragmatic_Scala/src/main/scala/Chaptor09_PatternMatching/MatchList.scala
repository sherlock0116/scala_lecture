package Chaptor09_PatternMatching

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object MatchList {
	
	def processItems(items: List[String]): Unit = {
		items match {
			case List("apple", "ibm") => println("Apples & IBMs")
			case List("red", "blue", "white") => println("Stars & Stripes......")
			case List("red", "blue", _*) => println("colors red, blue, ......")
			case List("apples", "oranges", otherFruit @ _*) =>
				println(s"apples, oranges, ${otherFruit.mkString(", ")}")
		}
	}
	
	def main(args: Array[String]): Unit = {
		
		processItems(List("apple", "ibm"))
		processItems(List("red", "blue", "white"))
		processItems(List("red", "blue", "green"))
		processItems(List("apples", "oranges", "bananas", "grapes"))
	}
}
