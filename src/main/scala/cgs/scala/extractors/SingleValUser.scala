package cgs.scala.extractors

/**
 * @Project: scala_lecture
 * @Description: TODO
 * @author: sherlock
 * @date Date:
 *
 * 可以认为unapply方法是apply方法的反向操作
 *      1. apply方法接受构造参数变成对象，
 *      2. unapply方法接受一个对象，从中提取值。
 */
trait SingleValUser {
	def name: String
}
class FreeSingleValUser(val name: String) extends SingleValUser
class PremiumSingleValUser(val name: String) extends SingleValUser

object FreeSingleValUser {
	def unapply(user: FreeSingleValUser) = Some(user.name)
}
object PremiumSingleValUser {
	def unapply(user: PremiumSingleValUser) = Some(user.name)
}

object TestSingleUser extends App {
	val user = new PremiumSingleValUser("miao")
	user match {
		case FreeSingleValUser(name) =>
			println (s"Hello ${name}")
		case PremiumSingleValUser(name) =>
			println (s"Welcome back, dear ${name}")
	}
}