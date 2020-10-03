package Chaptor07_UsingTraits.traits

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object UseFriend extends App {
	
	val john: Man = new Man("John")
	val sara: Woman = new Woman("Sara")
	val comet: Dog = new Dog("Comet")
	
	john.listen()
	sara.listen()
	comet.listen()
	
	val mansBestFriend: Friend = comet
	mansBestFriend.listen()
	
	def helpAsFriend(friend: Friend): Unit = friend.listen()
	
	helpAsFriend(sara)
	helpAsFriend(comet)
}
