package Chaptor04_WorkingWithObjects

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Greeter {
	
	def greet(): Unit = println("Ahoy, me hearties !")
}

/*
使用 scalac 编译 scalac Greeter.scala
javap -private Greeter

public final class Greeter {
	public static void greet();
}
 */