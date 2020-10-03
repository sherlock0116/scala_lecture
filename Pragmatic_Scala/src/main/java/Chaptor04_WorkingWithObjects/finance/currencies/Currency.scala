package Chaptor04_WorkingWithObjects.finance.currencies

import Chaptor04_WorkingWithObjects.finance.currencies.Currency.Currency

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Currency extends Enumeration {
	
	type Currency = Value
	val CNY, GBP, INR, NOK, PLN, SEK, USD = Value
}

class Money(val amount: Int, val currency: Currency) {
	
	override def toString: String = s"$amount $currency"
}

object UserCurrency extends App {
	
	Currency.values.foreach(e => println(e))
}