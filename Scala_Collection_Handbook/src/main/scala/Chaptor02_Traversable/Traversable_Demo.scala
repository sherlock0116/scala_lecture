package Chaptor02_Traversable


import java.util.concurrent.ForkJoinPool

import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection._
import scala.collection.parallel.{ForkJoinTaskSupport, ParIterable}
import scala.reflect.runtime.{universe => ru}

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object Traversable_Demo {
	
	/**
	 * 尽管 Scala 的类型信息在编译期间会被擦除
	 * 但是我们可以通过编译时的 TypeTag类保存用户编译时的类型信息,
	 * 因为它是在编译的时候生成的
	 *
	 * @param obj	对象
	 * @tparam T  泛型
	 * @return		类型信息
	 */
	def getTypeTag[T: ru.TypeTag](obj: T): ru.TypeTag[T] = {
		ru.typeTag[T]
	}
	
	def getInnerType[T](t: Traversable[T])(implicit tag: ru.TypeTag[T]): String = {
		tag.tpe.toString
	}
	
	def main(args: Array[String]): Unit = {
		
		val xs: Iterable[Int] = List(1, 2, 3)
		println(xs.getClass.getName)
		val tpe: ru.Type = getTypeTag(xs).tpe
		println(tpe)
		
		/*
			1. foreach(f: (A) = >Unit): Unit
			函数 f 的结果会被忽略, 所以一般函数的返回值为 Unit (即没有返回值)
			同时 foreach 本身也没有返回值
		 */
		xs.foreach(x => x * x) //  这个结果值不会返回, 所以外部获取不到
		xs.foreach(println)
		xs.foreach(x => println(x + 3))
		
		/*
			2. flatten()
		 */
		val tra1 = Traversable(Traversable(1, 2, 3), Traversable(2, 3, 4), Traversable(5, 6, 7, 8))
		val flat1: Traversable[Int] = tra1.flatten
		println(flat1)
		
		
		// 不可以做深层次的平展
		val tra2 = Traversable(
			Traversable(1, 2, 3),
			Traversable(2, 3, 4),
			Traversable(Traversable(5, 6, 7), Traversable(8, 9, 10))
		)
		val flat2 = tra2.flatten
		println(flat2)
		
		
		// 类型会被转换为公共父类 AnyVal
		val tra3 = Traversable(Traversable(1, 2, 3), Traversable(2L, 3L, 4L))
		val flat3 = tra3.flatten
		println(flat3)
		
		
		// 会将 None 值过滤掉
		val tra4 = Traversable(Some(1), None, Some(3))
		val flat4 = tra4.flatten
		println(flat4)
		
		/*
			2. 转置 Traversable 集合
			矩阵转置
			1, 2, 3			1, 4, 7
			4, 5, 6   ==>	2, 5, 8
			7, 8, 9			3, 6, 9
		 */
		// 如果集合中的每个集合元素内元素个数不相等, 会报错: transpose requires all collections have the same size
		val tra5 = Traversable(
			Traversable(1, 2, 3),
			Traversable(4, 5, 6),
			Traversable(7, 8, 9)
		)
		val trans: Traversable[Traversable[Int]] = tra5.transpose
		println(trans)
		
		/*
			3. unzip 操作是一种拉链操作, 会将集合分成两个部分
			def unzip[A1, A2](implicit asPair: (A) =>  (A1, A2)): (Traversable[A1], Traversable[A2])
		 */
		// 1. 当集合内元素本身就是 Tuple 类型
		val tra6 = Traversable("a" -> 1, "b" -> 2, "c" -> 3)
		val (a, b) = tra6.unzip
		println(s"a => ${a} \nb =>${b}")
		
		// 2. 更复杂一些, 我们可以显示的提供一个转换函数给 unzip 方法
		val tra7 = Traversable(
			"a_1", "b_2", "c_3"
		)
		val (a1, b1) = tra7.unzip(x => (x(0), x.substring(2).toInt))
		println(s"a1 => ${a1} \nb1 =>${b1}")
		// 或者可以提供一个隐式转换函数
		implicit def asPair(x: String): (String, Int) = {
			(x(0).toString, x(2).toInt)
		}
		val (a2, b2) = tra7.unzip
		println(s"a2 => ${a1} \nb2 =>${b1}")
		
		/*
			def unzip3[A1, A2, A3](implicit asTriple: (A) => (A1, A2, A3)): (Traversable[A1], Traversable[A2], Traversable[A3])
		 */
		val tra8 = Traversable(
			"电影ID, 评分, 电影名",
			"206142345, 8.2, 小王子",
			"201567231, 7.2, 海绵宝宝"
		)
		implicit def asTriple(x: String): (String, String, String) = {
			val strs: Array[String] = x.split(",")
			(strs(0), strs(1), strs(2))
		}
		val (x, y, z) = tra8.unzip3
		println(s"x: ${x}\ny: ${y}\nz: ${z}")
		
		/*
			在 Scala 中方法名不像 Java 中那样严格,所以使用了 ::, !, ? 等作为类名或方法名.
			但是在 JVM 中却不允许, 所以 Scala 使用了 mangled 技术, 即将它们编码成 $name
			的方式满足 JVM 的要求. 可以使用下面方法列出这些字符被编码后的样子:
			
			(~,$tilde)
			(=,$eq)
			(<,$less)
			(>,$greater)
			(!,$bang)
			(#,$hash)
			(%,$percent)
			(^,$up)
			(&,$amp)
			(|,$bar)
			(*,$times)
			(/,$div)
			(+,$plus)
			(-,$minus)
			(:,$colon)
			(\,$bslash)
			(?,$qmark)
			(@,$at)
		 */
		import scala.reflect.NameTransformer.encode
		val ops: String = "~=<>!#%^&|*/+-:\\?@"
		ops map {o => (o, encode(o.toString))} foreach println
		
		/*
			4. 连接两个 Traversable 到一个新的 Traversable, 使用 ++
			这两个 Traversable 所包含的元素类型可以不一致
			
			在 Traversable 的++ 方法实现中,结果的类型与左边的类型保持一致,
			所以左边的类型是什么, 其结果类型就是什么. 详见 tra11.getClass 和
			tra12.getClass 的区别
			
			在 Scala语言规范中, 方法名凡是以":"结尾的, 该方法的调用方都在方法名右侧
			
			结论:  ++ 和 ++: 方法其结果的类型都是由方法的调用方(也就是++方法左侧, ++:方法右侧)
			来决定的.
			
		 */
		val tra9 = Traversable("小王子", "海绵宝宝", "指环王")
		val tra10 = HashSet(9.7, 8.1, 9.9)
		val tra11 = tra9 ++ tra10		// tra9.++(tra10)
		println(tra11)
		
		println(tra11.getClass) 		// class scala.collection.immutable.$colon$colon
		println(getInnerType(tra11))
		
		val tra12: Traversable[Any] = tra10 ++ tra9
		println(tra12.getClass)		// class scala.collection.immutable.HashSet$HashTrieSet
		
		/*
			5. 连接多个 Traversable 对象到一个新的 Traversable
			Q: 如何连接多个 Traversable 到一个新的 Traversable? 根据上文中的方法, 我们
			通常可以这么做, A ++ B ++ C ++ D ++ ... ++ M, 但是因为 ++ 会产生很多中间集合结果, 浪费
			内存, 数据大的时候会影响 GC 垃圾回收, 所以它不是一个好的办法
			
			A: 正确的解决方法是使用 mutable.Traversable.concat
			
		 */
		// 这里的 : _* 是一个整体, 它告诉编译器将前面的参数当做一个参数序列处理
		val rel = mutable.Traversable.concat(
			Traversable(1 to 3: _*),
			Traversable(4 to 5: _*),
			Traversable(6 to 8: _*)
		)
		println(rel)
		
		/*
			6. 利用偏函数筛选元素
			
			Q: 假定有一个 Traversable 对象利用给定的偏函数筛选数据, 并将收集到的结果
			收集到新的 Traversable 中.
			
			A: collect
			def collect[B](pf: PartialFunction[A, B]): Traversable[B]
			
		 */
		val tra13 = Traversable(1 to 10: _*)
		def filterEven: PartialFunction[Int, Int] = {
			case x if x % 2 == 0 => x
		}
		
		val evens: Traversable[Int] = tra13 collect filterEven
		println(s"evens: $evens")
		
		/*
			7. 对所有的元素应用一个函数, 并将结果放入到新的 Traversable 对象中
			
			Q:如何对 Traversable 中的每一个元素都应用相同的函数, 并将函数结果
			放入到新的 Traversable 对象中?
			
			A: 可以使用更简洁的方法 map
			def map[B](f: A => B): Traversable[B]
		 */
		val tra14: Traversable[Int] = Traversable(1 to 5: _*)
		tra14 map (x => x * x) foreach print 			// 1 4 9 16 25
		
		/*
			8. 利用 scan 计算 Traversable 元素的阶乘
			如果要求一个 集合内元素的阶乘的值, tra14 map badFactorial 这个方法有个缺点: 它每次都会
			重复计算前一个数值的阶乘
			
			可以使用 scan/scanLeft/scanRight
			def scan[B >: A, That](z: B)(op: (B, B) => B) = scanLeft(z)(op)
			scan 接收两个参数, 第一个参数是运算初始值, 第二个参数是一个运算函数 op
			scan 方法在调用这个 op 函数的时候, 总是把前一个元素的结算结果作为函数 op 的第一个参数,
			将当前元素作为 op 的第二个参数.
			函数返回值的第一个元素是初始值, 如果不想要初始值, 可以使用 tail去掉
		 */
		def badFactorial(n: Int): Int = {
			if (n < 0) throw new IllegalArgumentException
			else if (n == 0) 1
			else (n * badFactorial(n - 1))
		}
		println(tra14 map badFactorial)			// List(1, 2, 6, 24, 120)
		println((tra14.scan(1)(_ * _)).tail)		// List(1, 2, 6, 24, 120)
		println(tra14.scanRight(1)(_ * _)) 		// List(120, 120, 60, 20, 5, 1)
		
		/*
			9. 使用指定的函数折叠 Traversable 的元素
			fold/foldLeft/foldRight
			这个方法的参数和计算过程和上面的 scan一模一样, 惟一的区别是:
			scan 会将中间计算结果作为最后集合内的元素返回出来,
			而 fold 只会返回最后一次计算出来的结果
			
			foldLeft 和 foldRight 还提供了简写的方法(/: 和 :\)
			
			Scala 中很很多函数都是通过 fold 来实现的
			1. 求和:  sum
			2.求积:  product
			3.计数:  count
			4.倒数第二个值: penultimate
			5.包含: contains
		 */
		println(tra14.fold(1)(_ * _))				// 120
		println(tra14.foldRight(1)(_ * _))		// 120
		
		val tra15 = Traversable('A' to 'E': _*).map(_.toString)
		
		println(tra15.fold("z")(_ + _))			// zABCDE
		println(tra15.foldRight("z")(_ + _))	// ABCDEz
		
		/*
			10. 判断一个 Traversable 是否为空
			
			isEmpty/nonEmpty/size/hasDefiniteSize
			只推荐使用 isEmpty 和 nonEmpty 来判断集合是否为空
			
		 */
		val tra16 = Traversable.empty
		println(tra16.isEmpty)					// true
		println(tra16.nonEmpty)					// false
		println(tra16.size)							// 0
		println(tra16.hasDefiniteSize)		// true
		
		/*
			11. 得到 Traversable 对象的特定的元素
			
			head/last/headOption/lastOption/find
			
			head 和 last 分别返回第一个和最后一个元素, 如果不存在则报错
			headOption 和 lastOption 会返回第一个和最后一个元素的 Option 类型
		 */
		val tra17 = Traversable(1 to 10: _*)
		println(tra17.headOption)				// Some(1)
		println(tra17.last)							// 10
		println(tra17.find(_ % 9 == 0))		// Some(9)
		
		/*
			12. 得到 Traversable 对象的尾部
			
			tail/tails/init/inits
			
			tail: 方法返回的不是最后一个元素, 它返回的是除去第一个元素外的其他所有元素
					所以一个 Traversable 对象其实就是由 head 和 tail 组成的, head :: tail
			tails: 这个方法很有趣, 它返回的是 Iterator[Traversable]对象,第一个值是原集合
					最后一个值是空集合
			
			init: 就是除去最后一个元素外的其他所有元素
			
			inits: 就是同上 tails
			
			在 Scala集合中 head 和 last相对,
			 						tail 和 init 相对,
			 						tails 和 inits 相对,
									take 和 drop相对,
									takeWhile 和 dropWhile 相对
		 */
		
		val tra18 = Traversable(1 to 5: _*)
		println(tra18.tail)		// List(2, 3, 4, 5)
		
		/*
			List(1, 2, 3, 4, 5)
			List(2, 3, 4, 5)
			List(3, 4, 5)
			List(4, 5)
			List(5)
			List()
		 */
		for (x <- tra18.tails) println(x)
		
		println(tra18.init)		// List(1, 2, 3, 4)
		
		/*
			List(1, 2, 3, 4, 5)
			List(1, 2, 3, 4)
			List(1, 2, 3)
			List(1, 2)
			List(1)
			List()
		 */
		for (x <- tra18.inits) println(x)
		
		/*
			13. 选择 Traversable 的一段子集
			
			slice
			def slice(from: Int, until: Int): Traversable[A]
			注意这里的返回值是左闭右开, 也就是说所截取的元素集合是包含 from 位置的元素,
			但是不包含 until 位置的元素. 即 from <= indexOf(x) < until
		 */
		val tra19 = Traversable(1 to 10: _*)
		println(tra19 slice(2, 5)) 		// List(3, 4, 5)
		
		/*
			14. 选取和跳过 Traversable 对象开头的 N 个元素
			
			take/takeWhile/drop/dropWhile
			
			take: 得到 Traversable 对象的前 N 个元素, 其实 take(n) = slice(0,n)
			takeWhile: 则是根据断言, 从头开始一直选择元素, 直到某个元素不满足这个断言为止
								def takeWhile(p: (A) => Boolean): Traversable[A]
								
			drop: 获取去除开头 N个元素外的剩下元素集合, 如果集合元素数量 < N, 返回空集合,
					如果N <= 0, 则返回整个集合
			
			dropWhile: 根据断言, 跳过开头满足断言的元素, 一旦某个元素不满足断言, 则返回剩下全部元素
		 */
		println(tra19.take(5))						// List(1, 2, 3, 4, 5)
		println(tra19.takeWhile(_ < 3))		// List(1, 2)
		
		/*
			15. 根据条件筛选元素
			
			filter/filterNot/withFilter
			
			filter: 从集合中选择满足断言条件的所有元素
			filterNot: 从集合中选择不满足断言的所有元素
			withFilter: 返回单子(FilterMonadic), 用于支持链式调用
		 */
		tra19.withFilter(_ > 2).withFilter(_ < 5).withFilter(_ % 2 == 0) foreach println		// 4
		
		/*
			16. 给 Traversable 对象的元素分组
			
			splitAt/span/partition/groupBy
			
			def splitAt(n: Int): (Traversable[A], Traversable[A])
			def span(p: (A) => Boolean): (Traversable[A], Traversable[A])
			def partition(p: (A) => Boolean): (Traversable[A], Traversable[A])
			def groupBy[K](f: (A) => K): Map[K, Traversable[A]]
			
			splitAt: 根据位置将 Traversable 对象分成两部分, 功能类似 c.take(n)、c.drop(n), 但是更加有效
			span: 它会一直选择元素, 直到某个元素不满足断言, 然后将前面的元素分成一组, 将后面的元素分成另一组
			partition: 将满足断言的元素和不满足断言的元素分成两个部分. 它和 span 的区别是,
			 				span 遇到某个元素不满足断言的时候就不再使用断言进行分割了,
			 				而 partition 会对所有元素进行断言判断, 断言结果为 true的分为一组, 等于 false 的分为另一组
			 groupBy: 按照条件将元素进行分组, 根据提供的函数生成分组关键字.
		 */
		println(tra19.splitAt(5)) 					// (List(1, 2, 3, 4, 5),List(6, 7, 8, 9, 10))
		println(tra19.span(_ % 2 != 0))			// (List(1),List(2, 3, 4, 5, 6, 7, 8, 9, 10))
		println(tra19.partition(_ % 2 != 0))	// (List(1, 3, 5, 7, 9),List(2, 4, 6, 8, 10))
		/*
			Map(
				2 -> List(2, 5, 8),
				1 -> List(1, 4, 7, 10),
				0 -> List(3, 6, 9)
			)
		 */
		println(tra19.groupBy(_ % 3))
		
		/*
			17. 检查 Traversable 对象中的元素是否满足条件
			
			forall/exists
			
			def forall(p: A => Boolean): Boolean
			def exists(p: A => Boolean): Boolean
			
			forall: 由于检查所有元素, 只有所有元素都使用断言 p 判断返回的结果都返回 true,
						那么 forall 方法才会返回 true, 如果集合为空, 次方法返回的结果也是 true.
			exists: 用来检查某个元素是否满足断言 p, 只要找到一个满足,那么返回的结果就是 ture,
		 */
		println(tra19.forall(_ <= 10))		// true
		println(tra19.forall(_ > 5))			// false
		println(tra19.exists(_ == 4))		// true
		
		/*
			18. 统计满足断言的元素个数
			
			count
			def count(p: A => Boolean): Int
		 */
		println(tra19.count(_ % 2 == 0)) 		// 5
		
		
		/*
			19. 规约操作
			reduce/reduceOption/reduceLeft/reduceRight
			reduceLeftOption/reduceRightOption
			
			reduce 操作类似以 fold, 只是 reduce 操作不提供初始值,
						它使用集合内的第一个元素作为初始值
						因此它几乎可以等于 t.tail.fold(t.head)(op)
		 */
		
		/*
			20. 在 Traversable 对象上调用聚合函数
			sum/product/min/max/aggregate/maxBy/minBy
			sum: 求和
			product: 求积
			min: 求最小值
			max: 求最大值
			maxBy/minBy: 根据测量函数的值大小来决定返回最大或最小的值
			
			aggregate: 是一个比 fold 和 reduce更抽象的高级函数,
							  它并不要求返回结果的类型是集合元素类型的父类
							  def aggregate[B](z: => B)(seqop: (B, A) => B, combop: (B, B) => B): B
							  z: 初始值, seqop在遍历分区的时候更新结果, combop: 汇总计算各分区的结果
		 */
		val words = Traversable("hello", "miao", "scala", "mushroom")
		println(words.aggregate(0)(_ + _.length, _ + _))		// 22
		
		/*
			21. 基于 Traversable 对象生成字符串
			mkString/addString/stringPrefix
		 */
		println(tra19.mkString(", "))					// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		println(tra19.mkString("[", ", ", "]"))		// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		
		/*
			22. 集合类型转换
			toArray
			toParArray
			toBuffer
			toIndexedSeq
			toIterable
			toIterator
			toList
			toSeq
			toSet
			toStream
			toVector
			toTraversable
			toMap
			to
		 */
		println(tra19.toArray)
		println(tra19.toBuffer)
		println(tra19.toIndexedSeq)
		println(tra19.toIterable)
		println(tra19.toIterator)
		println(tra19.toList)
		println(tra19.toSeq)
		println(tra19.toSet)
		println(tra19.toStream)
		println(tra19.toVector)
		println(tra19.toTraversable)
		println(tra19.to[immutable.Queue])
		
		/*
			23. 复制元素到一个数组
			
			copyToArray/copyToBuffer
			
			def copyToArray(xs: Array[A], start: Int): Unit
			def copyToBuffer[B >: A](dest: Buffer[B]): Unit
		 */
		val array: Array[Int] = new Array[Int](tra19.size)
		tra19.copyToArray(array)
		println(array.mkString("[", ", ", "]")) 		// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		
		val buffer: mutable.Buffer[Int] = mutable.Buffer[Int]()
		tra19.copyToBuffer(buffer)
		println(buffer)		// ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		
		/*
			24. 返回一个 Traversable 对象的视图 view
			view
			
			def view(from: Int, until: Int): TraversableView[A, Traversable[A]]
			
			参数 from, until 也是左闭右开, slice 和 view 的区别在于, view产生一个当前序列的非严格模式视图
			这意味着元素是延迟计算的, 只有在有需要的时候才计算元素. 而 slice 则会立刻产生一个新的集合
		 */
		var v = tra19.view
		v foreach println 	// 1 2 3 4 5 6 7 8 9 10
		
		v = tra19.view(2, 5)
		v foreach println 	// 3 4 5
		
		/*
			25. 得到 Traversable 对象的底层实现
			
			Traversable 是一个特质, 对于一个 Traversable 对象它必然有一个底层的实现类.
			
			repr
		 */
		println(tra19.repr)				// List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		println(mutable.Seq(1 to 5: _*).repr)		// ArrayBuffer(1, 2, 3, 4, 5)
		
		/*
			26. 使用一个相同的元素填充集合对象
			
			fill/iterate
			
			def fill[A](n: Int)(elem :=> A): Traversable[A]
			def fill(n1: Int, n2: Int)(elem :=> A): Traversable[Traversable[A]]
		 */
		println(Traversable.fill(5)("X"))			// List(X, X, X, X, X)
		println(Traversable.fill(5, 2)("Y"))		// List(List(Y, Y), List(Y, Y), List(Y, Y), List(Y, Y), List(Y, Y))
		println(Traversable.iterate(2, 5)(x => x * x)) 	// List(2, 4, 16, 256, 65536)
	
	/*
		27. 在某个值域上生成指定间隔的队列
		
		range
		
		def range[T](start: T, end: T, step: T)(imlpicit arg0: Integral[T]): Traversable[T]
		不提供step参数则默认为 1, start 和 end 参数也是左闭右开
	 */
		println(Traversable.range(1, 10, 2)) 		// List(1, 3, 5, 7, 9)
	
		
		/*
			28. 得到 Traversable 对象的串行对象和并行对象
			
			Seq/par
		 */
		val tra20 = Traversable(1 to 1000000: _*)
		
		val seqT: Traversable[Int] = tra20.seq
		val parT: ParIterable[Int] = tra20.par
		parT.tasksupport =  new ForkJoinTaskSupport(new ForkJoinPool(8))
		
		System.gc()
		val t1: Long = System.currentTimeMillis()
		val sum1: Int = seqT.sum
		val t2: Long = System.currentTimeMillis()
		// 串行 seqT 求和: 1784293664, 用时: 31
		println(s"串行 seqT 求和: ${sum1}, 用时: ${t2 - t1}")
		
		System.gc()
		val t3: Long = System.currentTimeMillis()
		val sum2: Int = parT.sum
		val t4: Long = System.currentTimeMillis()
		// 并行 parT 求和: 1784293664, 用时: 73
		println(s"并行 parT 求和: ${sum2}, 用时: ${t4 - t3}")
		
	}
}
