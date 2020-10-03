package Chaptor04_WorkingWithObjects

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Singleton extends App {
	
	println(MarkerFactory getMarker "blue")
	println(MarkerFactory getMarker "blue")
	println(MarkerFactory getMarker "red")
	println(MarkerFactory getMarker "red")
	println(MarkerFactory getMarker "green")
	
}

class Marker(val color: String) {
	
	println(s"Creating $this")
	override def toString: String = s"marker color $color"
}

object MarkerFactory {
	
	private val markers = scala.collection.mutable.Map (
		"red" -> new Marker("red"),
		"blue" -> new Marker("blue"),
		"yellow" -> new Marker("yellow")
	)
	
	def getMarker(color: String): Marker = {
		markers.getOrElseUpdate(color, new Marker(color))
	}
}