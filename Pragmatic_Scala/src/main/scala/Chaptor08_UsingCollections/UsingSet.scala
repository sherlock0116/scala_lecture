package Chaptor08_UsingCollections

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object UsingSet extends App {
	
	val colors1 = Set("Blue", "Green", "Red")
	println(s"colors1: $colors1")
	
	val colors2 = colors1 + "Black"
	println(s"colors2: $colors2")
	println(s"colors1: $colors1")
	
	println(colors1.getClass)
}
