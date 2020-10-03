package Chaptor04_WorkingWithObjects

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */

class Marker3 private(val color: String) {
	
	println(s"Creating $this")
	override def toString: String = s"marker color $color"
}

object Marker3 {
	
	private val markers = scala.collection.mutable.Map (
		"red" -> new Marker3("red"),
		"blue" -> new Marker3("blue"),
		"yellow" -> new Marker3("yellow")
	)
	
	def supportedColors: Iterable[String] = markers.keys
	def apply(color: String): Marker3 = markers.getOrElseUpdate(color, new Marker3(color))
	
	def main(args: Array[String]): Unit = {
		
		println(s"Supported colors are : ${Marker3.supportedColors}")
		println(Marker3("blue"))
		println(Marker3("red"))
	}
}