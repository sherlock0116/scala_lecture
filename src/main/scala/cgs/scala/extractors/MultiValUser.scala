package cgs.scala.extractors

import scala.collection.mutable

/**
 * @Project: scala_lecture
 * @Description: TODO
 * @author: sherlock
 * @date Date: 
 */
trait MultiValUser {
	def name: String
	def score: Int
}
class FreeMultiValUser(val name: String, val score: Int, val upgradeProbability: Double) extends MultiValUser
class PremiumMultiValUser(val name: String, val score: Int) extends MultiValUser

object FreeMultiValUser {
	def unapply(user: FreeMultiValUser) = {
		Some(user.name, user.score, user.upgradeProbability)
	}
}
object PremiumMultiValUser {
	def unapply(user: PremiumMultiValUser) = {
		Some(user.name, user.score)
	}
}

object PremiumCandidate {
	def unapply(user: FreeMultiValUser): Boolean = user.upgradeProbability > 0.75
}
object ObsoleteCandidate {
	def unapply(user: FreeMultiValUser): Boolean = user.upgradeProbability < 0.5
}

object TestMultiUser extends App {
	val user: FreeMultiValUser = new FreeMultiValUser("mi", 95, 0.4)
//	val user: PremiumMultiValUser = new PremiumMultiValUser("miao", 23)
	user match {
//		case FreeMultiValUser(name, _, upgradeProbability) =>
//			if (upgradeProbability > 0.75) println(s"${name}, what can we do for you today?") else println(s"Hello ${name}")
//		case PremiumMultiValUser(name, _) =>
//			println(s"Welcome back, dear ${name}")
		case user@ PremiumCandidate() =>
			println(s"congratulations, ${user.name}, you are passed")
		case user@ ObsoleteCandidate() =>
			println(s"sorry to inform, ${user.name}, you are obsolete")
	}

	val xs = 58 #:: 43 #:: 93 #:: 66 #:: 88 #:: Stream.empty
	xs match {
		case first #:: second #:: _ =>
			println(s"first - second = ${first} - ${second} = ${first - second}")
//		case Stream(first, second, other@_*) =>
//			println(s"first - second = ${first} - ${second} = ${first - second}")
		case _ => -1
	}

	val map = mutable.Map[String, String]()
	val li: List[String] = List("-zk", "127.0.0.1:2181", "-tag", "12")
	li match {
		case "-zk" :: value :: tail =>
			map.put("zk", value)
			println(s"${tail}")
		case "-tag" :: value :: tail =>
			map.put("tag", value)
			println(s"${tail}")
	}
	map.foreach(x => {
		println(s"key: ${x._1}, value: ${x._2}")
	})

}