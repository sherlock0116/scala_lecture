package cgs.scala.function

/**
 * @Project: scala_lecture
 * @Description: TODO
 * @author: sherlock
 * @date Date: 
 */
object PartialFunctionDemo extends App {

	val df: PartialFunction[Any, Unit] = {
		case s: String => println(s"Got a String [${s}]")
		case _ => println("not a String")
	}

	df("hello")
	df(5)

}
