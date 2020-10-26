/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */

package object Chaptor01_String {
	
	/**
	 	Scala 的 String 乍一看和 Java 的没有任何区别.
	 	"Hello".getClass.getName 其结果也是 java.lang.String.
	 	
	 	因为 Scala 隐式转换的魔法, String类拥有 StringOps 类中所有方法的访问权限
	 	并且其中一部分有 StringLike, 一部分有 WrappedString 等
	 
	 	1.1 测试字符串的相等性
	 	Java 中对于引用类型, == 比较的是引用类型的地址值, equals() 比较的是引用类型的值内容.
	 	Scala 中对于所有类型, == 比较的就是值内容, eq() 方法才是比较引用类型的地址值.
	 
	 	1.6 字符串中的查找
	 	在一个 String 上调用 .r 可以创建一个 Regex 对象
		查找是否含有一个匹配时就可以使用 findFirstIn
	 	查找是否完全匹配时可以使用 findAllIn
	 
	 */
	
	implicit class StringImprovements(val s: String) {
		
		def increment: String = s.map(c => (c + 1).toChar)
	}
}
