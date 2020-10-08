package Chaptor02_Traversable

import scala.collection.immutable.{HashSet, TreeSet}
import scala.collection.mutable
import scala.util.Random

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Iterable_Demo {
	
	val it10: Iterable[Int] = Iterable(1 to 10: _*)
	val lt5 = Iterable('A' to 'E': _*)
	
	def main(args: Array[String]): Unit = {
		
		/*
			1. 将 Iterable 对象分组
			
			grouped: 可以根据指定元素数量, 将集合分成几个小集合.
			
			它和 groupBy 分组函数不同, groupBy是根据计算的键值进行分组的,
			而 grouped 是根据元素数量进行分组, 所以分组的元素数量一定要大于 0
			
		 */
		val rel: Iterator[Iterable[Int]] = it10.grouped(3)
		/*
			List(1, 2, 3)
			List(4, 5, 6)
			List(7, 8, 9)
			List(10)
		 */
		while (rel.hasNext)
			println(rel.next)
			
		/*
			以滑动窗口的方式分组 Iterable 对象
			sliding
			
			def sliding(size: Int, step:Int): Iterator[Iterable[A]]
			如果不传入 step 参数,默认步长为 1
		 */
		val ite1: Iterator[Iterable[Int]] = it10.sliding(3, 3)
		/*
			List(1, 2, 3)
			List(4, 5, 6)
			List(7, 8, 9)
			List(10)
		 */
		while (ite1.hasNext)
			println(ite1.next)
		
		val ite2: Iterator[Iterable[Int]] = it10.sliding(3, 2)
		/*
			List(1, 2, 3)
			List(3, 4, 5)
			List(5, 6, 7)
			List(7, 8, 9)
			List(9, 10)
		 */
		while (ite2.hasNext)
			println(ite2.next)
		
		val ite3: Iterator[Iterable[Int]] = it10.sliding(3, 4)
		/*
			List(1, 2, 3)
			List(5, 6, 7)
			List(9, 10)
		 */
		while (ite3.hasNext)
			println(ite3.next)
		
		/*
			2. zip 两个集合
			
			def zip[B](that: GenIterable[B]): Iterable[(A, B)]
			
			zip 方法组合另外一个集合, 将所对应的元素组成一对, 放入到新的集合中,
			生成的集合中的元素为 Tuple2 类型.
			
			如果两个集合长度不等, 则以较短的那个为准, 较长的集合中剩余的元素会被忽略,
			不再进行组合
			
			如果集合是无序集合, 则每次运行的时候的结果可能都不一样
		 */
		val it3 = Iterable(1 to 3: _*)
		val it5 = Iterable('A' to 'E': _*)
		val ite4: Iterable[(Int, Char)] = it3 zip it5
		println(ite4)		// List((1,A), (2,B), (3,C))
		
		val xs = mutable.HashSet(X("A"), X("B"), X("C"))
		val xn = mutable.HashSet(X(1), X(2), X(3))
		// Set((X(A),X(3)), (X(B),X(1)), (X(C),X(2)))
		// Set((X(A),X(2)), (X(C),X(3)), (X(B),X(1)))
		println(xs zip xn)
		
		/*
			3. zipAll 两个长度不同的集合
			
			def zipAll[B](that: Iterable[B], thisElem: A, thatElem: B): Iterable[(A, B)]
			
			zipAll 用来组合长度不同的两个 Iterable 对象, 并为较短的那个集合提供默认值,
			它提供了额外的两个参数 thisElem: A 和 thatElem: B,
			分别代表方法左边集合的默认值和方法右边集合的默认值
		 */
		
		/*
			4. 使用本身索引 zip 一个 Iterable 集合
		 */
		val ite5 = lt5.zipWithIndex
		println(ite5)		// List((A,0), (B,1), (C,2), (D,3), (E,4))
		
		val ite6 = ite5 map (x => (x._2, x._1))
		println(ite6)		// List((0,A), (1,B), (2,C), (3,D), (4,E))
		
		/*
			4. 检查两个 Iterable 是否包含相同的元素且顺序一致
			
			sameElements
		 */
		val let3 = Iterable("A", "B", "C")
		println(let3.sameElements(mutable.Iterable("A", "B", "C")))			// true
		println(let3.sameElements(mutable.Iterable("A", "C", "B")))			// true
		println(let3.sameElements(mutable.Iterable("A", "B", "C", "D")))	// false
		
		val s1 = HashSet(1, 2)
		val s2 = mutable.HashSet(1, 2)
		val s3 = mutable.TreeSet(1, 2)
		val s4 = TreeSet(2, 1)
		val s5 = Seq(1, 2)
		println(s1.sameElements(s2)) 	// true
		println(s1.sameElements(s3)) 	// true
		println(s1.sameElements(s4)) 	// true
		println(s1.sameElements(s5)) 	// true
		
		/*
			5. 得到尾部的 N 个元素
			
			takeRight()
		 */
		println(it10.takeRight(4))		// List(7, 8, 9, 10)
		
		/*
			6. 去掉尾部的 N个元素
		 */
		println(it10.dropRight(4))		// List(1, 2, 3, 4, 5, 6)
		
	}
	
	class X(val x: Any) {
		override def hashCode(): Int = Random.nextInt()
		override def toString: String = s"X($x)"
	}
	object X {
		def apply(x: Any): X = new X(x)
	}
}
