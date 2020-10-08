/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
package object Chaptor02_Traversable {
	
	/**
		第二章 Traversable
	 	
	 			本书中不严格区分类和特质的继承(inherits)、实现(implements)、扩展(extends)、
	 	混入(with/mixin)这个几个概念, 统一称之为继承.
	 			当一个类扩展或混入了一个特质时, 我们将此特质称之为此类的父特质.
	 			
	 			Traversable 是一个 Trait, 它是其他集合的父特质. 它的子特质 immutable.Traversable 和
	 	mutable.Traversable 分别是不可变集合和可变集合的父特质.
	 			
	 			Traversable 特质的定义如下
	 			
	 			trait Traversable[+A] extends TraversableLike[A, Traversable[A]]
	 					with GenTraversable[A]
	 					with TraversableOnce[A]
	 					with GenericTraversableTemplate[A, Traversable]
	 			
	 			
	 			Traversable 的方法都是单线程使用的, 也就是非线程安全的. 如果想要让某个方法的处理
	 	并行的执行, 需要使用 scala.collection.parallel, scala.collection.parallel.immutable,
	 	scala.collection.parallel.mutable 包下的集合.
	 			
	 			严格类型的集合在使用前其所有元素都是已经计算出来的. 相反非严格类型的集合的元素是
	 	延迟计算, 只有在使用它们的时候才正式计算得出, 例如 Stream.
	 			
	 			trait 是不可以直接实例化, 我们通常的做法是在特制的伴生对象中提供 apply 方法.
	 			同理, Traversable 的实例化方法也位于伴生对象的 apply 方法中.
	 			
				def apply[A](elems: A*): Traversable[A] = {
					if (elems.isEmpty) empty[A]
					else {
						val b = newBuilder[A]
						b ++= elems
						b.result()
					}
				}
	 			
	 			它其实是通过 object Traversable 的 newBuilder 方法创建的生成器生成的, 这里
	 	的 newBuilder 是一个 mutable.ListBuffer 对象, 调用它的 result方法就会得到 List 对象.
	 	
	 	Q1: 如果类型为 Traversable 的元素所包含的元素的类型不一致怎么办?
		其生成的集合的元素类型是什么?
	 	A1: 寻找元素的最近的相同的父类型, 不管怎样,肯定会有共同的"祖先"(例如 Any, AnyVal, AnyRef...)
	 	scala> val tra = Traversable(Traversable(1,2,3), Traversable(2L, 3L, 4L))
		tra: Traversable[Traversable[AnyVal]] = List(List(1, 2, 3), List(2, 3, 4))

		scala> val tt = tra.flatten
		tt: Traversable[AnyVal] = List(1, 2, 3, 2, 3, 4)
	 
	 	因为 Traversable 特质定义时就定义为协变的: Traversable[+A], 因此 Traversable[Int], Traversable[Long]
	 	Traversable[Short]等都可以看做是 Traversable[AnyVal]的子类
	 	
	 	Q2: 如果集合的元素有的是普通类型, 有的是集合类型,那么能平展开么?
	 	A2: 答案是不能. flatten 方法要求集合的元素需要继承或者转换成 GenTraversable才可以.
	 	比如 Traversable(Traversable(1, 2, 3), Traversable(2, 3, 4), 5) 就不可以平展开, 但是如果
	 	加上隐式 view implicit def int2Traversable[T <: Any](n: T) = Traversable[T](n), 就能做平展了
	 
	 	Q3: 如果类型为集合的元素中所包含的元素又是集合类型 , 会不会也被平展出来? 也就是说, 会不会
	 	深度平展?
	 	A3: 不会, 平展方法只会做浅层平展. 例如:
	 	scala> val tra1 = Traversable(Traversable(1, 2, 3), Traversable(2, 3, 4), Traversable(Traversable(5, 6, 7), Traversable(8, 9, 10)))
		tra1: Traversable[Traversable[Any]] = List(List(1, 2, 3), List(2, 3, 4), List(List(5, 6, 7), List(8, 9, 10)))

		scala> val tt1 = tra1.flatten
		tt1: Traversable[Any] = List(1, 2, 3, 2, 3, 4, List(5, 6, 7), List(8, 9, 10))
	 	
	 	可见更深层次的 List(5, 6, 7), List(8, 9, 10)都没有被平展开
	 	
	 	flatten还有一个更常用的功能, 就是它可以将 Traversable[Option[A]] 平展成 Traversable[A], 移除
	 	了 None 的元素
	 	scala> val tra2 = Traversable(Some(1), None, Some(3))
		tra2: Traversable[Option[Int]] = List(Some(1), None, Some(3))

		scala> val tt2 = tra2.flatten
		tt2: Traversable[Int] = List(1, 3)
	 
	 
	 
	 */
}
