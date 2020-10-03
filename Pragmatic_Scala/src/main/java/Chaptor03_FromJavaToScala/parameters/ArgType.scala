package Chaptor03_FromJavaToScala.parameters

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object ArgType {
	
	def function(input: Int*) = input.getClass
	
	def main(args: Array[String]): Unit = {
		
		// class scala.collection.mutable.WrappedArray$ofInt
		println(function(1, 2, 3))
	}
}
