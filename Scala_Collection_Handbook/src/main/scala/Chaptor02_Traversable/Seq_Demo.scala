package Chaptor02_Traversable

import scala.util.Random


/**
 * @Description
 *
 * 	Seq 特质代表按照一定顺序排列的元素的列表. 序列是一种特别的可迭代的集合,
 * 	它包含了重复的元素, 并且元素的顺序关系是确定的, 每个元素对应一个索引值.
 * 	所以, 除了首尾元素外, 每个元素不是在其他元素之前就是在其他元素之后.
 *
 * 	我们可以好好用利用索引这个属性操作元素, 如 segmentLength、prefixLength、
 * 	indexWhere、indexOf......
 *
 * 	相关的类和 Trait
 * 	collection.Seq
 * 	collection.IndexedSeq
 * 	collection.LinearSeq
 *
 * 	immutable.IndexedSeq
 * 	immutable.LinearSeq
 * 	immutable.Vector
 * 	immutable.Range
 * 	immutable.NumericRange
 * 	immutable.IndexedSeq
 *
 * 	mutable.LinearSeq
 * @Author sherlock
 * @Date
 */
object Seq_Demo {
	
	val seq5 = Seq(1 to 5: _*)
	val seq10 = Seq(1 to 10: _*)
	
	def main(args: Array[String]): Unit = {
		
		/*
			1. 得到序列的索引集合
			
			indices
		 */
		val rs = seq10.indices
		println(rs)		// Range 0 until 10 等价于 0 until seq10.length
		
		/*
			2. 得到指定索引位置的元素
			apply
		 */
		println(seq10(5)) 		// 6
		
		/*
			3. 寻找指定元素的索引
			indexOf/lastIndexOf
			
			因为 Seq 允许有重复的元素, 所以搜索某个元素的时候应该确定寻找的是哪个元素
			
			indexOf: 返回寻找到的第一个指定元素的索引位置, 如果指定起始位置,
						   将从起始位置开始查找
			
			lastIndexOf: 它总是返回满足条件的最后一个元素, 如果指定了 end 值,
								  则总是在索引 index <= end 的范围内查找.
		 */
		val seq20 = seq10 ++ seq10
		println(seq20.indexOf(5))					// 4
		println(seq20.indexOf(5, 10))			// 14
		println(seq20.lastIndexOf(9))			// 18
		println(seq20.lastIndexOf(9, 10))		// 8
		
		/*
			4. 寻找满足条件的元素索引
			indexWhere/lastIndexWhere
			
			如果满足满条件的元素有多个
			 		indexWhere 只会返回满足条件的第一个元素的索引位置
					lastIndexWhere 会返回满足条件的最后一个元素的索引位置
		 */
		println(seq10.indexWhere(x => (x % 2 == 0 && x < 5)))				// 1
		println(seq10.lastIndexWhere(x => (x % 2 == 0 && x < 5)))		// 3
		
		/*
			5. 寻找指定的子序列
			indexOfSlice/lastIndexOfSlice
			
		 */
		println(seq10.indexOfSlice(Seq(7, 8)))			// 6
		println(seq10.indexOfSlice(Seq(7, 8), 7))		// -1
		
		println(seq10.lastIndexOfSlice(Seq(7, 8)))			// 6
		println(seq10.lastIndexOfSlice(Seq(7, 8), 7))		// 6
		
		/*
			6. 增加元素到序列中(这些方法也会生成新的序列, 原序列不变)
			+:/:+/padTo
			
			因为 Scala 中规定方法名以":"结尾, 方法的调用方都在方法名右侧
			因此 +: 就是头插法添加元素, :+ 就是尾插法添加元素
			
			padTo(len: Int, elem: A): 基于当前序列生成长度为 len 的序列
			如果原有序列长度 < len, 除了复制原有序列前 N个元素到新序列外,
			还会使用 elem 填充满新序列. 如果原有序列长度 > len, 则会保留
			原有序列长度和所有元素到新序列中.
			
		 */
		
		println(seq5 :+ 6)		// List(1, 2, 3, 4, 5, 6)
		println(6 +: seq5)		// List(6, 1, 2, 3, 4, 5)
		println(seq5.padTo(10, 6))			// List(1, 2, 3, 4, 5, 6, 6, 6, 6, 6)
		println(seq5.padTo(3, 6))			// List(1, 2, 3, 4, 5)
		
		println(seq5)		// List(1, 2, 3, 4, 5)
		
		/*
			7. 替换序列中的元素
			
			patch
			
			def patch(from: Int, that: GenSqe[A], replaced: Int): Seq[A]
			from 指定了要替换的位置;
			replaced 指定了要替换元素的数量;
			that: 需要替换后的元素
			
			这个方法不是等量替换, 替换后的序列的长度可能变长, 可能变短, 可能等于原长
		 */
		println(seq10.patch(5, Seq(12, 13), 3))		// List(1, 2, 3, 4, 5, 12, 13, 9, 10)
		
		/*
			8. 更新指定位置的元素值
			
			immutable.Seq.updated/mutable.Seq.update
			
			updated: 对于可变集合和不可变集合, 该方法都会生成一个新的序列
			而对于可变序列, 使用 update 方法或简便写法, 它实现的是原地修改, 而不是创建一个新的序列.
		 */
		println(seq10.updated(9, 100))	// List(1, 2, 3, 4, 5, 6, 7, 8, 9, 100)
		println(seq10)								// List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		
		val mutSeq = scala.collection.mutable.Seq(1 to 10: _*)
		println(s"before update: ${mutSeq}")	// before update: ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
		mutSeq(9) = 100	// 等价于 mutSeq.update(9, 100)
		println(s"after update: ${mutSeq}")		// after update: ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 100)
		
		println(mutSeq.updated(9, 1000))			// ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 1000)
		println(s"after updated: ${mutSeq}")	// after updated: ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 100)
		
		
		/*
			9. 排序
			
			sortBy/sortWith/sorted
			
			def sortBy[B](f: (A) => B)(implicit ord: math.Ordering[B]): Repr
			def sortWith(lt: (A, A) => Boolean): Repr
			def sorted[B >: A](implicit ord: math.Ordering[B]):Repr
			
			sorted: 它使用的是一个隐式的 math.Ordering 进行排序. 它保证是稳定排序,
						 相等的元素排序后位置不变. 首先它将元素复制到一个数组中, 然后调用
						 java.utl.Arrays.sort 进行排序, 最后将排序后的数组复制到新的集合中.
						 虽然 Arrays.sort 的排序速度很快(TimSort), 但是 Scala至少进行了两次
						 的复制集合的操作, 所以对于数据量巨大的集合来说, 如果追求更好的性能
						 这不是一个理想的选择.
			
			sortBy: 需要传入一个 f: A=>B 参数, 这个方法可以将集合的元素转换成一个可排序
						 的对象, sortBy将根据这个对象进行排序.
			
			sortWith: 需要一个可以比较两个元素的函数 lt: (A, A) => Boolean,
			 				  scala 根据这个函数排序.
			 
			 在内部实现上, Scala 都是转换成 sorted 这个方法进行排序的.
				
		 */
		val randomSeq = Seq.fill(5)(Random.nextInt(100))
		println(randomSeq.sorted)													// List(10, 42, 57, 68, 85)
		println(randomSeq.sortBy(e => (e.toString.length, e)))		// List(10, 42, 57, 68, 85)
		println(randomSeq.sortWith(_ - _ < 0))							// List(10, 42, 57, 68, 85)
		
		/*
			10. 反转一个序列(函数会返回新的序列)
			reverse/reverseIterator/reverseMap
			
			reverseMap: 除了反转的功能外,还包含映射的功能, 而且它比
								  seq.reverse.map 更加有效, 因为它是在一次遍历中实现了
								  反转和映射这两个功能
		 */
		println(seq5.reverse)								// List(5, 4, 3, 2, 1)
		println(seq5.reverseIterator.next())	// 5
		println(seq5.reverseMap(_ * 10))			// List(50, 40, 30, 20, 10)
		
		
		/*
			11. 集合操作 (函数返回生成新的集合)
			求交集, 并集, 差集
			intersect: 交集
			diff: 差集
			union: 并集
			
		*/
		val seq_1 = Seq(1 to 5: _*)
		val seq_2 = Seq(3 to 7: _*)
		println(seq_1 union seq_2)				// 并集: List(1, 2, 3, 4, 5, 3, 4, 5, 6, 7)
		println(seq_1 intersect seq_2)		// 交集: List(3, 4, 5)
		println(seq_1 diff seq_2)				// 差集: List(1, 2)
		
		/*
			12. 去重
			
			distinct
		*/
		
	}
}
