package Chaptor03_FromJavaToScala.circulation

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Greet extends App {
	
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
