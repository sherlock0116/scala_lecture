package Chaptor03_FromJavaToScala.parameters

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object DefaultValues {
	
	def mail(destination: String = "head office",
			 mailClass: String = "first") = {
		
		println(s"sending to $destination by $mailClass class")
	}
	
	def main(args: Array[String]): Unit = {
		
		mail("Houston office", "Priority")
		mail("Boston office")
		mail()
		
		// 可以使用命名参数的方式使代码可读性更高
		mail(mailClass = "second", destination = "LosAngels")
	}
}
