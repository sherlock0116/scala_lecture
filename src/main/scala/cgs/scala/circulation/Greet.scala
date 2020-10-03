package cgs.scala.circulation

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Greet {
	
	def main(args: Array[String]): Unit = {
		
		for (i <- 1 to 3) {
			print (s"$i, ")
		}
		println("Scala Rocks !!!")
		
		for (i <- 1 until 4) {
			print (s"$i, ")
		}
		println("Scala Rocks !!!")
		
		(1 to 3).foreach(i => print(s"$i, "))
		println("Scala Rocks !!!")
	}
}
