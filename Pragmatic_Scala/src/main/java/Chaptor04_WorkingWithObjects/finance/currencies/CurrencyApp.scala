package Chaptor04_WorkingWithObjects.finance.currencies

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object CurrencyApp extends App {
	
	val moneyInGBP: Money = new Money(10, Currency.GBP)
	
	println(Charge.chargeInUSD(moneyInGBP))
	// 同样的这里也可以使用包对象中的 convert, 避免 Convert 噪声
	println(convert(moneyInGBP, Currency.USD))
}
