package Chaptor04_WorkingWithObjects.finance.currencies

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Charge {
	
	def chargeInUSD(money: Money): String = {
		// 这里可以直接使用包对象中的 convert 方法中, 可以避免使用 Convert 占位符噪声
//		def moneyInUSD: Money = Converter.convert(money, Currency.USD)
		def moneyInUSD: Money = convert(money, Currency.USD)
		
		s"""charged $$${moneyInUSD.amount}"""
	}
}
