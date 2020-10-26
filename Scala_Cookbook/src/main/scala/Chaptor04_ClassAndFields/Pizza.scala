package Chaptor04_ClassAndFields

import Chaptor04_ClassAndFields.Pizza.{DEFAULT_CRUST_SIZE, DEFAULT_CRUST_TYPE}

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Pizza(var crustSize: Int, var crustType: String) {
	
	def this(crustSize: Int) {
		this(crustSize, DEFAULT_CRUST_TYPE)
	}
	
	def this(crustType: String) {
		this(DEFAULT_CRUST_SIZE, crustType)
	}
	
	def this() {
		this(DEFAULT_CRUST_SIZE, DEFAULT_CRUST_TYPE)
	}
	
}

object Pizza {
	
	val DEFAULT_CRUST_SIZE: Int = 12
	val DEFAULT_CRUST_TYPE: String = "thin"
	
	def main(args: Array[String]): Unit = {
		
		val p1: Pizza = new Pizza(DEFAULT_CRUST_SIZE, DEFAULT_CRUST_TYPE)
		val p2: Pizza = new Pizza(DEFAULT_CRUST_SIZE)
		val p3: Pizza = new Pizza(DEFAULT_CRUST_TYPE)
		val p4: Pizza = new Pizza()
	}
	
	
}