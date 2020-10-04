package Chaptor07_UsingTraits

import java.io.StringWriter

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class MethodBinding

abstract class Writer {
	def writeMessage(msg: String): Unit
}

trait UpperCaseWriter extends Writer {
	abstract override def writeMessage(msg: String): Unit = super.writeMessage(msg.toUpperCase)
}

trait ProfanityFilteredWriter extends Writer {
	abstract override def writeMessage(msg: String): Unit = super.writeMessage(msg.replace("stupid", "s-----"))
}

class StringWriterDelegate extends Writer {
	val writer: StringWriter = new java.io.StringWriter
	def writeMessage(msg: String): Unit = writer.write(msg)
	override def toString: String = writer.toString
}

object MethodBinding extends App {
	
	val myWriterProfanityFirst = new StringWriterDelegate with UpperCaseWriter with ProfanityFilteredWriter
	val myWriterProfanityLast = new StringWriterDelegate with ProfanityFilteredWriter with UpperCaseWriter
	
	myWriterProfanityFirst writeMessage "There is no sin except stupidity"
	myWriterProfanityLast writeMessage "There is no sin except stupidity"
	
	println(myWriterProfanityFirst)
	println(myWriterProfanityLast)
}