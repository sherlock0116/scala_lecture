package Chaptor03_FromJavaToScala.parameters

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object ImplicitParameters {
	
	def connectToNetWork(user: String)(implicit wifi: Wifi): Unit = {
		println(s"User: $user connected to WIFI: $wifi")
	}
	
	def atOffice(): Unit = {
		println("-------- at office --------")
		implicit def officeNetwork: Wifi = new Wifi("office-network")
		val cafeterisNetwork: Wifi = new Wifi("cafe-network")
		
		connectToNetWork("guest")(cafeterisNetwork)
		connectToNetWork("Jill Coder")
		connectToNetWork("Joe Hacker")
	}
	
	def atJoesHome(): Unit = {
		println("-------- at Joe's home --------")
		implicit def homeNetwork: Wifi = new Wifi("home-network")
		
		connectToNetWork("guest")(homeNetwork)
		connectToNetWork("Joe Hacker")
	}
	
	
	def main(args: Array[String]): Unit = {
		
		atOffice()
		atJoesHome()
	}
}

class Wifi (name: String) {
	override def toString: String = name
}
