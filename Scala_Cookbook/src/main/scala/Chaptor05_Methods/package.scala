/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
package object Chaptor05_Methods {
	
	/**
	 * 5.1 控制方法作用域
	 * Scala 中的方法允许更加细粒度的控制其可见性
	 * 修饰符							描述
	 * private[this]				仅仅对当前实例可见, 最严格可见性
	 * private						对当前类的所有实例以及伴生对象可见
	 * protected					仅对当前类及其子类可见
	 * private[package]			对 package 包及其子包下的类可见
	 * 无修饰符						默认为 public, 所有均可见
	 *
	 * 5.2 调用父类(特质)的方法
	 * (1). 在通常情况下, Scala 直接调用一个父类的方法和 Java 是相通的: 用 super 代表父类, 然后是方法的调用
	 * (2). 如果类继承了多个特质, 并且这些特质都实现了同样的方法, 在使用 super 调用父类方法时,
	 * 	  不仅要选择调用的方法, 还可以选择要调用的特质
	 */
}
