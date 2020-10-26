package Chaptor01_String

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object ImplicitsInObject {
	
	implicit class StringImprovements(val s: String) {
		def increment: String = s.map(c => (c + 1).toChar)
	}
	
	
}
