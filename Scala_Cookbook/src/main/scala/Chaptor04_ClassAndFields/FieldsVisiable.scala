package Chaptor04_ClassAndFields

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
object FieldsVisiable extends App {
	
	val cat: Cat = new Cat("miao")
	println(cat.name)
	cat.name = "mi"
	println(cat.name)
	
	val dog: Dog = new Dog("wang")
	println(dog.name)
//	dog.name = "ggggg"		// 因为 Dog 的 name 属性是 val 修饰的, 不会生成 setter 方法, 无法修改
	
	val bird: Bird = new Bird("gua")
//	println(bird.name)		// 因为 Bird 的 name 属性没有任何修饰的, 不会生成 getter/setter 方法
	
	val rabbit: Rabbit = new Rabbit("ji")
//	println(rabbit.name)		// 因为 Rabbit 的 name 属性有 private修饰, 只能在伴生对象中访问

}

class Cat(var name: String)

class Dog(val name: String)

class Bird(name:String)

class Rabbit(private var name: String)

object Rabbit extends App {
	
	val cat: Cat = new Cat("miao")
	println(cat.name)
	cat.name = "mi"
	println(cat.name)
	
	val dog: Dog = new Dog("wang")
	println(dog.name)
	//	dog.name = "ggggg"		// 因为 Dog 的 name 属性是 val 修饰的, 不会生成 setter 方法, 无法修改
	
	val bird: Bird = new Bird("gua")
//	println(bird.name)		// 因为 Bird 的 name 属性没有任何修饰的, 不会生成 getter/setter 方法
	
	val rabbit: Rabbit = new Rabbit("ji")
	println(rabbit.name)		// 因为 Rabbit 的 name 属性有 private修饰, 只能在伴生对象中访问
	rabbit.name = "li"
	println(rabbit.name)
}

/**
  	这里贴出 4 个类的反编译后的 Java 代码
	
	========================================================
 	1. Cat.class (var 修饰 name 字段生成了 getter/setter 方法)
	========================================================
 	package Chaptor04_ClassAndFields;
	import scala.reflect.ScalaSignature;

	@ScalaSignature(bytes = "\006\001)2A!\002\004\001\023!A\001\003\001BA\002\023\005\021\003\003\005\036\001\t\005\r\021\"\001\037\021!!\003A!A!B\023\021\002\"B\023\001\t\0031#aA\"bi*\tq!\001\rDQ\006\004Ho\034:1i}\033E.Y:t\003:$g)[3mIN\034\001a\005\002\001\025A\0211BD\007\002\031)\tQ\"A\003tG\006d\027-\003\002\020\031\t1\021I\\=SK\032\fAA\\1nKV\t!\003\005\002\02459\021A\003\007\t\003+1i\021A\006\006\003/!\ta\001\020:p_Rt\024BA\r\r\003\031\001&/\0323fM&\0211\004\b\002\007'R\024\030N\\4\013\005ea\021\001\0038b[\026|F%Z9\025\005}\021\003CA\006!\023\t\tCB\001\003V]&$\bbB\022\003\003\003\005\rAE\001\004q\022\n\024!\0028b[\026\004\023A\002\037j]&$h\b\006\002(SA\021\001\006A\007\002\r!)\001\003\002a\001%\001")
	public class Cat {
  		private String name;
  
  		public String name() {
    		return this.name;
  		}
  
	  	public void name_$eq(String x$1) {
			this.name = x$1;
	  	}
  
  		public Cat(String name) {}
		}
 		
 		========================================================
 		2. Dog.class (val 修饰 name 字段只生成了 getter 方法)
		========================================================
 		package Chaptor04_ClassAndFields;
		import scala.reflect.ScalaSignature;

		@ScalaSignature(bytes = "\006\001\t2A\001B\003\001\021!Aq\002\001BC\002\023\005\001\003\003\005\035\001\t\005\t\025!\003\022\021\025i\002\001\"\001\037\005\r!un\032\006\002\r\005A2\t[1qi>\024\b\007N0DY\006\0348/\0218e\r&,G\016Z:\004\001M\021\001!\003\t\003\0255i\021a\003\006\002\031\005)1oY1mC&\021ab\003\002\007\003:L(+\0324\002\t9\fW.Z\013\002#A\021!#\007\b\003']\001\"\001F\006\016\003UQ!AF\004\002\rq\022xn\034;?\023\tA2\"\001\004Qe\026$WMZ\005\0035m\021aa\025;sS:<'B\001\r\f\003\025q\027-\\3!\003\031a\024N\\5u}Q\021q$\t\t\003A\001i\021!\002\005\006\037\r\001\r!\005")
		public class Dog {
  			private final String name;
  
  			public String name() {
    			return this.name;
  			}
  
  			public Dog(String name) {}
		}
 		
 		========================================================
 		3. Bird.class (无修饰 name 字段没有生成了 getter/setter 方法)
		========================================================
 		package Chaptor04_ClassAndFields;
		import scala.reflect.ScalaSignature;

		@ScalaSignature(bytes = "\006\001}1Aa\001\003\001\017!Aa\002\001B\001B\003%q\002C\003\033\001\021\0051D\001\003CSJ$'\"A\003\0021\rC\027\r\035;peB\"tl\0217bgN\fe\016\032$jK2$7o\001\001\024\005\001A\001CA\005\r\033\005Q!\"A\006\002\013M\034\027\r\\1\n\0055Q!AB!osJ+g-\001\003oC6,\007C\001\t\030\035\t\tR\003\005\002\023\0255\t1C\003\002\025\r\0051AH]8pizJ!A\006\006\002\rA\023X\rZ3g\023\tA\022D\001\004TiJLgn\032\006\003-)\ta\001P5oSRtDC\001\017\037!\ti\002!D\001\005\021\025q!\0011\001\020\001")
		public class Bird {
  			public Bird(String name) {}
		}
 		
 		========================================================
 		4. Rabbit.class ()
 		========================================================
 		package Chaptor04_ClassAndFields;
		import scala.Function0;
		import scala.reflect.ScalaSignature;
		import scala.runtime.BoxedUnit;

		@ScalaSignature(bytes = "\006\001E3A\001E\t\001)!A1\004\001BA\002\023%A\004\003\005)\001\t\005\r\021\"\003*\021!y\003A!A!B\023i\002\"\002\031\001\t\003\tt!B\033\022\021\0031d!\002\t\022\021\0039\004\"\002\031\007\t\003Y\004b\002\037\007\005\004%\t!\020\005\007\003\032\001\013\021\002 \t\017\t3!\031!C\001\007\"1qI\002Q\001\n\021Cq\001\023\004C\002\023\005\021\n\003\004N\r\001\006IA\023\005\b\035\032\021\r\021\"\001P\021\031\001f\001)A\005e\t1!+\0312cSRT\021AE\001\031\007\"\f\007\017^8saQz6\t\\1tg\006sGMR5fY\022\0348\001A\n\003\001U\001\"AF\r\016\003]Q\021\001G\001\006g\016\fG.Y\005\0035]\021a!\0218z%\0264\027\001\0028b[\026,\022!\b\t\003=\025r!aH\022\021\005\001:R\"A\021\013\005\t\032\022A\002\037s_>$h(\003\002%/\0051\001K]3eK\032L!AJ\024\003\rM#(/\0338h\025\t!s#\001\005oC6,w\fJ3r)\tQS\006\005\002\027W%\021Af\006\002\005+:LG\017C\004/\005\005\005\t\031A\017\002\007a$\023'A\003oC6,\007%\001\004=S:LGO\020\013\003eQ\002\"a\r\001\016\003EAQa\007\003A\002u\taAU1cE&$\bCA\032\007'\r1Q\003\017\t\003-eJ!AO\f\003\007\005\003\b\017F\0017\003\r\031\027\r^\013\002}A\0211gP\005\003\001F\0211aQ1u\003\021\031\027\r\036\021\002\007\021|w-F\001E!\t\031T)\003\002G#\t\031Ai\\4\002\t\021|w\rI\001\005E&\024H-F\001K!\t\0314*\003\002M#\t!!)\033:e\003\025\021\027N\0353!\003\031\021\030M\0312jiV\t!'A\004sC\n\024\027\016\036\021")
		public class Rabbit {
  			private String Chaptor04_ClassAndFields$Rabbit$$name;
  
  			public static Rabbit rabbit() {
    			return Rabbit$.MODULE$.rabbit();
  			}
  
  			public static Bird bird() {
    			return Rabbit$.MODULE$.bird();
  			}
  
  			public static Dog dog() {
    			return Rabbit$.MODULE$.dog();
  			}
  
  			public static Cat cat() {
    			return Rabbit$.MODULE$.cat();
  			}
			
			public static void main(String[] paramArrayOfString) {
				Rabbit$.MODULE$.main(paramArrayOfString);
		  	}
  
  			public static void delayedInit(Function0<BoxedUnit> paramFunction0) {
    			Rabbit$.MODULE$.delayedInit(paramFunction0);
  			}
  
  			public static long executionStart() {
    			return Rabbit$.MODULE$.executionStart();
  			}
  
  			public String Chaptor04_ClassAndFields$Rabbit$$name() {
    			return this.Chaptor04_ClassAndFields$Rabbit$$name;
  			}
  
  			public void Chaptor04_ClassAndFields$Rabbit$$name_$eq(String x$1) {
    			this.Chaptor04_ClassAndFields$Rabbit$$name = x$1;
  			}
  
  			public Rabbit(String name) {}
		}
 */