package Chaptor03_FromJavaToScala.tuples

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object MultipleAssignment {
	
	def getPersonInfo: (String, String, String) = {
		("Venkat", "Subramaniam", "Venkat@agideveloper.com")
	}
	
	def main(args: Array[String]): Unit = {
		
		val (firstname, lastname, email) = getPersonInfo
		println(s"""
			  |firstname: $firstname
			  |lastname: $lastname
			  |email: $email
			  |""".stripMargin)
		
		val info: (String, String, String) = getPersonInfo
		println(s"""
				   |firstname: ${info._1}
				   |lastname: ${info._2}
				   |email: ${info._3}
				   |""".stripMargin)
	}
}
