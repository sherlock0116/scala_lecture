package Chaptor03_FromJavaToScala

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Access extends App {
	
	val microwave: Microwave = new Microwave
	microwave.start()
	// 类中私有方法和字段仅在伴生对象中可见
	//microwave.turnTable()
	
}

class Microwave {
	
	def start(): Unit = println("started")
	def stop(): Unit = println("stopped")
	private def turnTable(): Unit = println("turning table")
	
}

object Microwave extends App {
	
	val microwave: Microwave = new Microwave
	microwave.start()
	// 类中私有方法和字段仅在伴生对象中可见
	microwave.turnTable()
	
}