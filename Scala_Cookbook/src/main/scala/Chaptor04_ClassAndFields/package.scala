/**
* @Description TODO
* @Author sherlock
* @Date  
*/
package object Chaptor04_ClassAndFields {
	
	/**
	 * Scala 的柱构造函数是以下的组合
	 * 		1. 构造函数的参数
	 * 		2. 类内部被调用的方法
	 * 		3. 类内部可执行的语句和表达式
	 * 通俗的说 class xxx(name: String){...} 小括号内为构造参数, 大括号内部的可执行代码会在类实例化
	 * 的时候全部执行...
	 *
	 * 在类中除了方法外的其他定义都会成为 Scala 柱构造函数的一部分
	 *
	 * _$eq 方法是 Scala 提供的修改 var 字段的语法糖, 它等同于 Java 中的 setter 方法.
	 * 在实际开发中使用 p.age = 10, 编译后其实调用就是 p.age_$eq(10) 这个方法.
	 *
	 * 控制构造函数字段的可见性
	 * 	1. 如果一个字段被声明为 var, Scala 会为该字段生成 getter/setter 方法
	 * 	2. 如果字段是 val, Scala 只会生成 getter 方法
	 * 	3. 如果一个字段没有 var/val 修饰, Scala 较为保守, 不会生成 getter/setter 方法
	 * 	4. 另外, var 和 val 字段可以被 private 修饰, 这样可以防止生成 getter/setter 方法,
	 * 		只有在伴生对象中可以访问该字段
	 *
	 * 定义私有的构造函数(实现单例)
	 * 	在类名和构造函数之间插入一个 private 关键字. 然后在伴生对象中提供实例的访问方法.
	 *
	 * 4.10 在继承时处理构造函数参数
	 * 照常将基类的构造函数参数定义为 var 或 val. 当定义一个子类构造函数时, 不要使用 var 或 val
	 * 声明类间公用的字段. 然后在子类中用 var 或 val 定义新的构造函数的参数
	 *
	 *
	 * 4.13 在抽象类(或特质)中定义属性字段
	 * 可以在抽象类(或特质)中把抽象字段(注意这里是抽象字段)声明为 var/val.
	 * 抽象类(或特质)中抽象字段的工作方式很有趣.
	 * (1). 抽象 var 字段生成 getter/setter 方法
	 * (2). 抽象 val 字段只生成 getter 方法
	 * (3). 抽象类(或特质)中的抽象字段, Scala 编译器都不会在结果代码中创建该字段,
	 * 	  只会生成该字段对应的 getter/setter 方法
	 * (4). 抽象类的继承类在编译后会, 在结果代码中生成抽象类中的字段属性, 详见 Pet.scala
	 * (5). 要阻止抽象类中的具体的 val 字段被子类覆写, 可以将其声明为 final val
	 *
	 * 4.14 使用 case 类生成模板代码的好处
	 * (1). 会自动生成 apply 方法, 初始化的时候不需要使用关键字 new
	 * (2). case 类构造参数默认为 val, 并会自动生成参数的访问方法, 如果参数改为 var 也会有修改后的方法
	 * (3). 会生成一个默认的toString 方法
	 * (4). 会生成一个 unapply 方法. 模式匹配时很好用
	 * (5). 会生成 equals 和 hashcode 以及 copy 方法
	 */
}