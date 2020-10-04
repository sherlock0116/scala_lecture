package Part01_Introduction_of_functional_programming.What_is_functioal_programming

/**
 * @Description
 * 		一家咖啡店的购物程序
 * 			先写带有副作用的 Scala程序
 * @Author sherlock
 * @Date
 */

class Cafe {
	
	/*
		这里 cc.charge()产生了副作用, 因为信用卡的计费涉及与外部的交互
		而且这个副作用导致这段代码很难被测试, 因为在测试时我们不希望
		真的去联系信用卡公司并对卡片计费
		如果有用户多次重复购买咖啡, 该方法会被短时间内多次重复调用
		
		所以我们可以让 buyCoffee()返回一个 Charge 对象代替一次副作用
	 */
//	def buyCoffee(cc: CreditCard): Coffee = {
//		val cup: Coffee = new Coffee()
//		cc.charge(cup.price)
//		cup
//	}
	
	def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
		val cup: Coffee = new Coffee("latte", 12.5D)
		(cup, Charge(cc, cup.price))
	}
	
	
	
}

object Cafe extends App {
	
	//
}

case class CreditCard(number: Long)

case class Coffee (name: String, price: Double)

case class Charge(cc: CreditCard, d: Double)