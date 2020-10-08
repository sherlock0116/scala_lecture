/**
 *
 * 第一部分 函数式编程
 * 	1. 什么是函数式编程
 * 	2. 在 Scala 中使用函数式编程
 * 	3. 函数式数据结构
 * 	4. 不使用异常来处理错误
 * 	5. 严格求值和惰性求值
 * 	6. 纯函数式状态
 *
 * 第二部分 功能设计和组合子库
 * 	7. 纯函数式并行计算
 * 	8. 基于性质的测试
 * 	9. 语法分析器组合子
 *
 * 第三部分
 */
package object Part01_Introduction_of_functional_programming {
	
	/**
		一. 什么是函数式编程
		
				函数式编程基于一个简单又蕴意深远的前提: 只用纯函数来构造程序
		换句话说, 函数没有副作用.
				一个带有副作用的函数不仅只是简单地返回一个值, 还干了其他事情, 比如:
		1.	修改一个变量
		2.	直接修改数据结构
		3. 设置一个对象的成员
		4. 抛出一个异常或者一个错误停止
		5. 打印到终端或读取用户的输入
		6. 读取或写入一个文件
		7. 在屏幕上绘画
		
				函数式编程限制的是怎样写程序, 而非表达什么样的程序.
				本书将学习到如何没有副作用的表达我们的程序, 包括执行 I/O、处理错误、
		修改数据.
				纯函数的模块化特性, 它们很容易被测试、复用、并行化、泛华以及推导
				
				什么是纯函数?
				对于一个输入类型为 A, 输出类型为 B的函数 f (用 Scala 写为: A => B), 它是一种
		将所有的 A 类型的值 a 关联到确切的 B 类型的值 b 的运算过程, 即 b 完全由 a 来决定.
	 	任何内部的或外部的过程状态改变都不会影响到 f(a)的计算结果.
	 			我们可以使用引用透明 (referential transparency) 的概念对纯函数进行形式化.
	 			
	 			在 Java 和 Scala 中, 字符串都是不可变的. 一个修改过的字符串其实是新的字符串,
	 	旧的字符串保持不变.
	 	
	 	scala> val s = "Hello World"
		s: String = Hello World

		scala> val s1 = s.reverse
		s1: String = dlroW olleH

		scala> val s2 = s.reverse
		s2: String = dlroW olleH

		scala> s1 == s2
		res0: Boolean = true
	 	
	 			可以看到 s1 == s2, 这么做并不影响结果, 所以 s 是引用透明的. 另外, s1 和 s2 也同样是引用透明的,
	 	如果它们出现在某个程序中可以替代为它们所引用的值而不会对程序造成影响

	 			接着来看一个不是引用透明的例子. 比如 StringBuilder 里的 append 方法.
	 	
	 	scala> val sb = new StringBuilder("hello")
		sb: StringBuilder = hello

		scala> val s1 = sb.append(", world").toString
		s1: String = hello, world

		scala> val s2 = sb.append(", world").toString
		s2: String = hello, world, world
	 
	 			可以看到 s1 和 s2 不在相等, 在 s2 调用 sb.append 的时候, s1 就已经改变了 sb 的引用的对象. 所以我们
	 	断定 StringBuilder 的 append 方法不是一个纯函数
	 
	 	二、在 Scala 中使用函数式编程
	 	
	 			本节会主要讨论如何使用尾递归函数(tail rescursive function)来实现一段循环逻辑,
		也会引入高阶函数(HOF). 高阶函数可以使用函数作为参数或者将函数作为它的返回值输出,
	 	我们也会看到一些多态高阶函数的例子.
	 		
	 			什么是多态函数 ?
	 	这里的多态与我们熟悉的 Java 面向对象编程中的多态稍微有些诧异, 面向对象的多态通常
		是指某种形式的子类型或继承关系. 这些例子中没有接口或子类型. 这里的多态有时也称为
	 	参数化多态.
	 	
	 */
}
