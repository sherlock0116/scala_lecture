package Chaptor07_UsingTraits.traits

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Human(val name: String) extends Friend

class Woman(override val name: String) extends Human(name)

class Man(override val name: String) extends Human(name)
