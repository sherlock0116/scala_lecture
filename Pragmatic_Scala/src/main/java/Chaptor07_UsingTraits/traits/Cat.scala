package Chaptor07_UsingTraits.traits

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Cat(val name: String) extends Animal {
	
}

object Cat extends App {
	
	val angel: Cat with Friend = new Cat("angel") with Friend
	UseFriend.helpAsFriend(angel)
}
