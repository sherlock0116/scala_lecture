package Chaptor04_ClassAndFields

/**
 * @Description
 * @Author sherlock
 * @Date
 */
abstract class Pet(name: String) {
	
	val greeting: String
	var age: Int
	
	def sayHello {
		println(s"$greeting")
	}
	
	override def toString: String = s"I say $greeting, and I'm $age years old."
}

class Cow(name: String) extends Pet(name) {
	override val greeting: String = "Moo"
	override var age: Int = 5
}

class Fox(val name: String) extends Pet(name) {
	override val greeting: String = "bark"
	override var age: Int = 2
}

object TestPet extends App {
	
	val cow: Cow = new Cow("Fifo")
	val fox: Fox = new Fox("snow")
	
//	cow.greeting = "miao"			// 因为 greeting 字段是 val 所以不提供 setter 方法, 无法修改值

	cow.sayHello
	fox.sayHello
	
	println(cow)
	println(fox)
	
	fox.age = 1
	println(fox)
	

}

/**

=========================================
Pet.class
=========================================
package Chaptor04_ClassAndFields;
import scala.Predef$;
import scala.reflect.ScalaSignature;

@ScalaSignature(bytes = "\006\001Y2Q\001C\005\002\0021A\001b\005\001\003\002\003\006I\001\006\005\006?\001!\t\001\t\005\bI\001\021\rQ\"\001&\021\0351\003\0011A\007\002\035Bqa\013\001A\002\033\005A\006C\0033\001\021\0051\007C\0035\001\021\005SGA\002QKRT\021AC\001\031\007\"\f\007\017^8saQz6\t\\1tg\006sGMR5fY\022\0348\001A\n\003\0015\001\"AD\t\016\003=Q\021\001E\001\006g\016\fG.Y\005\003%=\021a!\0218z%\0264\027\001\0028b[\026\004\"!\006\017\017\005YQ\002CA\f\020\033\005A\"BA\r\f\003\031a$o\\8u}%\0211dD\001\007!J,G-\0324\n\005uq\"AB*ue&twM\003\002\034\037\0051A(\0338jiz\"\"!I\022\021\005\t\002Q\"A\005\t\013M\021\001\031\001\013\002\021\035\024X-\032;j]\036,\022\001F\001\004C\036,W#\001\025\021\0059I\023B\001\026\020\005\rIe\016^\001\bC\036,w\fJ3r)\ti\003\007\005\002\017]%\021qf\004\002\005+:LG\017C\0042\013\005\005\t\031\001\025\002\007a$\023'\001\005tCfDU\r\0347p+\005i\023\001\003;p'R\024\030N\\4\025\003Q\001")

public abstract class Pet {

	public abstract String greeting();
  	public abstract int age();
  	public abstract void age_$eq(int paramInt);
  
  	public void sayHello() {
    	Predef$.MODULE$.println(String.valueOf(greeting()));
  	}
  
  	public String toString() {
    	return (new StringBuilder(27)).append("I say ").append(greeting()).append(", and I'm ").append(age()).append(" years old.").toString();
  	}
  
  	public Pet(String name) {}
}


=========================================
Fox.class
=========================================
package Chaptor04_ClassAndFields;
import scala.reflect.ScalaSignature;
@ScalaSignature(bytes = "\006\001Y2A!\003\006\001\033!A!\003\001BC\002\023\0051\003\003\005\"\001\t\005\t\025!\003\025\021\025\021\003\001\"\001$\021\0351\003A1A\005BMAaa\n\001!\002\023!\002b\002\025\001\001\004%\t%\013\005\b]\001\001\r\021\"\0210\021\031)\004\001)Q\005U\t\031ai\034=\013\003-\t\001d\0215baR|'\017\r\033`\0072\f7o]!oI\032KW\r\0343t\007\001\031\"\001\001\b\021\005=\001R\"\001\006\n\005EQ!a\001)fi\006!a.Y7f+\005!\002CA\013\037\035\t1B\004\005\002\03055\t\001D\003\002\032\031\0051AH]8pizR\021aG\001\006g\016\fG.Y\005\003;i\ta\001\025:fI\0264\027BA\020!\005\031\031FO]5oO*\021QDG\001\006]\006lW\rI\001\007y%t\027\016\036 \025\005\021*\003CA\b\001\021\025\0212\0011\001\025\003!9'/Z3uS:<\027!C4sK\026$\030N\\4!\003\r\tw-Z\013\002UA\0211\006L\007\0025%\021QF\007\002\004\023:$\030aB1hK~#S-\035\013\003aM\002\"aK\031\n\005IR\"\001B+oSRDq\001N\004\002\002\003\007!&A\002yIE\nA!Y4fA\001")

public class Fox extends Pet {

  private final String name;
  private final String greeting;
  private int age;
  
  public String name() {
    return this.name;
  }
  
  public Fox(String name) {
    super(name);
    this.greeting = "bark";
    this.age = 2;
  }
  
  public String greeting() {
    return this.greeting;
  }
  
  public int age() {
    return this.age;
  }
  
  public void age_$eq(int x$1) {
    this.age = x$1;
  }
}
 
 */
