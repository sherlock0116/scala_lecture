package cgs.scala.constructor

/**
 * Descriptor:
 * Author: sherlock
 */
class RagDoll {
	var name: String = _
	var gender: String = _
	var age: Int = _

	def this(name: String, gender: String, age: Int) = {
		this
		println("进入辅助构造方法 this { }")
		this.name = name
		this.gender = gender
		this.age = age
		println("退出辅助构造方法 this { }")
	}
	println("class RagDoll { } 这里相当于在普通代码块 { } 中")
}

object RagDoll {

	def main(args: Array[String]): Unit = {
		println("进入 main 方法 main { }")
		val doll = RagDoll("布偶", "female", 2)
		println(s"Ragdoll: ${doll.name}, ${doll.gender}, ${doll.age}")
		println("退出 main 方法 main { }")
	}

	def apply(name: String, gender: String, age: Int): RagDoll = {
		println("进入 apply 方法 apply { }")
		val doll = new RagDoll(name, gender, age)
		println("退出 apply 方法 apply { }")
		doll
	}

	println("object RagDoll { } 这里相当于在静态代码块 static { } 中")
}
