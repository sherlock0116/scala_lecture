package Chaptor04_ClassAndFields
import scala.collection.mutable.ArrayBuffer

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class PandorasBox {
	
	case class Thing(name: String)
	
	val things: ArrayBuffer[Thing] = scala.collection.mutable.ArrayBuffer[Thing]()
	things += Thing("Evil thing #1")
	things += Thing("Evil thing #2")
	
	def addThing(name: String) {
		things += Thing(name)
	}
	
}

object TestPandorasBox extends App {
	
	val box: PandorasBox = new PandorasBox
	box.addThing("Evil thing #11")
	
	box.things.foreach(println)
}
