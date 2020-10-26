package Chaptor05_Methods

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
abstract class Human {
	def hello = "the human trait"
}

trait Mother extends Human {
	override def hello = "Mother"
}

trait Father extends Human {
	override def hello = "Father"
}

class Child extends Human
		with Father
		with Mother {
	
	def printSuper = super.hello
	def printMother = super[Mother].hello
	def printFather = super[Father].hello
	def printHuman = super[Human].hello
}

class Daughter{ }

object TestChild extends App {
	
	val child: Child = new Child
	
	/*
		child.printSuper = Mother
		child.printMother = Mother
		child.printFather = Father
		child.printHuman = the human trait
	 */
	println(s"child.printSuper = ${child.printSuper}")
	println(s"child.printMother = ${child.printMother}")
	println(s"child.printFather = ${child.printFather}")
	println(s"child.printHuman = ${child.printHuman}")
	
	/*
		illegal inheritance; superclass Daughter is not a subclass of the superclass Human of the mixin trait Father
	 	这里编译不通过因为 trait Father 已经有一个超类 Human, 如果 Daughter 要混入 trait Father,
	 	Daughter 必须是超类 Human 的子类,  如果 Daughter 不是 Human 的子类,
	 	那么 trait Father 就会有两个超类 Human 和 Daughter, 这违反了单继承原则.
	 */
//	val daughter = new Daughter with Father with Mother
	
}