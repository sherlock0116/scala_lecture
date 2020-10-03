package Chaptor05_WorkingUseOfTypes

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */

class Pet(val name: String) {
	override def toString: String = name
}

class Dog(override val name: String) extends Pet(name)

object PlayWithPets {
	
	// 默认不变
	def workWithPets1(pets: Array[Pet]): Unit = {
		println(s"play with pets: ${pets.mkString(", ")}")
	}
	
	// 支持协变
	def workWithPets2[T <: Pet](pets: Array[T]): Unit = {
		println(s"play with pets: ${pets.mkString("[", ", ", "]")}")
	}
	
	// 支持逆变
	def copyPets[S, D >: S](fromPets: Array[S], toPets: Array[D]): Unit = {}
	
	def main(args: Array[String]): Unit = {
		
		val dogs: Array[Dog] = Array(new Dog("Rover"), new Dog("Comet"))
		// 编译报错, 因为 Scala 默认不变(这里发生了协变)
//		workWithPets1(dogs)
		
		workWithPets2(dogs)
		
		val pets: Array[Pet] = new Array[Pet](10)
		copyPets(dogs, pets)
	}
}
