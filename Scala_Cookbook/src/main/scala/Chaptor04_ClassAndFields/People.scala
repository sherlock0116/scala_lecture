package Chaptor04_ClassAndFields

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
case class People(name: String, var age: Int) {
	
	private def canEquals(that: Any): Boolean = that.isInstanceOf[People]
	
	override def hashCode(): Int = {
		val prime: Int = 31
		var result: Int = 1
		result = prime * result + age
		result = prime* result + (if (name.isEmpty) 0 else name.toLowerCase.hashCode)
		result
	}
	
	override def equals(that: Any): Boolean = {
		that match {
			case that: People => that.canEquals(this) && that.hashCode == this.hashCode
			case _ => false
		}
	}
}

object People {
	
	def apply(): People = new People("<no name>", 0)
	def apply(name: String): People = new People(name, 0)
	def apply(name: String, age: Int): People = new People(name, age)
	
	def main(args: Array[String]): Unit = {
		
		val jack1: People = People("Jack", 23)
		val jack2: People = People("JACK", 23)
		val jack3: People = People("JACK", 25)
		val lucy: People = People("Lucy", 12)
		
		println(s"jack1 == jack2 [${jack1 == jack2}]")
		println(s"jack1 == jack3 [${jack1 == jack3}]")
		println(s"jack == lucy [${jack1 == lucy}]")
	}
}
