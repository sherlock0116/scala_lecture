package Chaptor03_FromJavaToScala

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */

package society {
	
	package professional {
		class Executive {
			private[professional] var workDetails = null
			private[society] var friends = null
			private[this] var secrets = null
			
			def help(another: Executive): Unit = {
				println(another.workDetails)
				println(secrets)
				// 编译报错, this 修饰的成员只可以在当前类中使用
				// println(another.secrets)
			}
		}
		
		class Assistant {
			def assist(anExec: Executive): Unit = {
				println(anExec.workDetails)
				println(anExec.friends)
			}
		}
	}
	
	package social {
		
		class Acquaintance {
			def socialize(person: professional.Executive): Unit = {
				println(person.friends)
				// 编译报错, 因为 workDetails 的访问范围是在闭包professional中, 所以在当前包social中无法访问
				//println(person.workDetails)
			}
		}
	}
}

