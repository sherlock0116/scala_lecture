package Chaptor04_WorkingWithObjects.finance

import Chaptor04_WorkingWithObjects.finance.currencies.Currency.Currency

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
package object currencies {
	
	def convert(money: Money, to: Currency): Money = {
		
		// 假设当前市场汇率
		val conversionRate: Int = 2
		new Money(money.amount * conversionRate, to)
	}
}
