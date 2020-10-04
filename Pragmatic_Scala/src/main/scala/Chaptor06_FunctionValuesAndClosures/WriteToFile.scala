package Chaptor06_FunctionValuesAndClosures

import java.io.{File, PrintWriter}

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object WriteToFile {
	
	def writeToFile(fileName: String)(closure: PrintWriter => Unit): Unit = {
		
		val writer: PrintWriter = new PrintWriter(new File(fileName))
		try {
			closure(writer)
		}finally {
			writer.close()
		}
	}
	
	def main(args: Array[String]): Unit = {
		
		val fileName: String = "/Users/sherlock/IdeaProjects/scala_lecture/output.txt"
		writeToFile(fileName) {writer =>
			writer write "hello from scala."
		}
	}
}
