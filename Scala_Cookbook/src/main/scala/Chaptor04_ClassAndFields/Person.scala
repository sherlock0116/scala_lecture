package Chaptor04_ClassAndFields

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Person(val firstName: String, val lastName:String) {
	
	println("the constructor begins...")
	
	// class fields
	private val HOME = System.getProperty("user.home")
	var age = 5
	
	// some methods
	override def toString: String = s"$firstName $lastName is $age years old "
	def printHome {println(s"HOME = $HOME")}
	def printFullName {println(this)}
	
	printHome
	printFullName
	println("still in the constuctor...")
}

object Person extends App {
	
	val p: Person = new Person("Adam", "Meyer")
	
	p.age = 10
	println(p)
	
	// scala 中的 field_$eq 就相当于 java 中的 set 方法
	// 但在实际使用中不要这么做.
	p.age_$eq(8)
	println(p)
	
}
