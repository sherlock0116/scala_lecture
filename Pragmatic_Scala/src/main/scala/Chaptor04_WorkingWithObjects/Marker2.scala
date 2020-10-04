package Chaptor04_WorkingWithObjects

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Marker2 private(val color: String) {
	
	println(s"Creating $this")
	override def toString: String = s"marker color $color"
}

object Marker2 {
	
	private val markers = scala.collection.mutable.Map (
		"red" -> new Marker2("red"),
		"blue" -> new Marker2("blue"),
		"yellow" -> new Marker2("yellow")
	)
	
	def getMarker(color: String): Marker2 = {
		markers.getOrElseUpdate(color, new Marker2(color))
	}
	
	def main(args: Array[String]): Unit = {
		
		println(Marker2 getMarker "blue")
		println(Marker2 getMarker "blue")
		println(Marker2 getMarker "red")
		println(Marker2 getMarker "red")
		println(Marker2 getMarker "green")
	}
	
}

