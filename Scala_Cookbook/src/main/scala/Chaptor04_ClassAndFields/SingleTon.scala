package Chaptor04_ClassAndFields


/**
 * @Description
 * 		Scala 实现单例
 * @Author sherlock
 * @Date
 */
class SingleTon private {
	
	override def toString: String = "this is a singleton !"
}

object SingleTon {
	
	private lazy val singleTon = new SingleTon
	def getInstance: SingleTon = singleTon
}

object TestSingleTon extends App {
	
	val s1: SingleTon = SingleTon.getInstance
	val s2: SingleTon = SingleTon.getInstance
	
	println(s"SingleTon 实现了单例模式: [${s1 eq s2}]")
}
