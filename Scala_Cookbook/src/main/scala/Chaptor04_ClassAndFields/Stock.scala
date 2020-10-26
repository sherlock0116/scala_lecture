package Chaptor04_ClassAndFields

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
// 如果定义为 class Stock(private[this] val price: Double) { ...... }
// 那么伴生对象也无法访问伴生类中 private 修饰的构造参数的 setter 方法
// 只有伴生类中可以访问, 其他任何类实例都不行, 例如下面的 that
class Stock(private var price: Double) {
	
	def isHigherThan(that: Stock): Boolean = {
		this.price > that.price
	}
}

object Stock extends App {
	
	val stock: Stock = new Stock(0.1)
	
	// 在伴生对象中依然可以访问 伴生类中 private 修饰的构造参数的 getter/setter 方法
	stock.price = 1.9
	println(stock.price)			// 1.9
}

object Driver extends App {
	
	val s1: Stock = new Stock(0.9)
	val s2: Stock = new Stock(1.2)
	
	println(s1 isHigherThan s2)
	
	// 这里编译不通过, 因为主构造函数中的字段是 private 修饰
	// 其他任何独立对象中都没有 getter/setter 的访问权限
//	s1.price = 1.5
//	println(s1.price)
}
