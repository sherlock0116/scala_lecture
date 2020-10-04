package Chaptor03_FromJavaToScala

/**
 * @Description
 *             Scala 中, protected 修饰的成员仅对自己和派生类可见
 *             tips: 即使在派生类中,也无法使用方法所属实例来访问 protected 方法
 * @Author sherlock
 * @Date
 */
object Protected extends App {
	
}

class Vehicle {
	protected def checkEngine(): Unit = {}
}

class Car extends Vehicle {
	
	def start(): Unit = {
		checkEngine()
	}
	
	def tow(car: Car): Unit = {
		car.checkEngine()
	}
	
	def tow(vehicle: Vehicle): Unit = {
		// 这里编译会报错, protected 仅仅可以在本类中使用本类实例或派生类中使用派生类实例来访问
//		vehicle.checkEngine()
	}
}

class GasStation {
	
	def fillGas(vehicle: Vehicle): Unit = {
		// 因为 GasStation 不是派生类, 所以 checkEngine 方法对它不可见
		// vehicle.checkEngine()
	}
}