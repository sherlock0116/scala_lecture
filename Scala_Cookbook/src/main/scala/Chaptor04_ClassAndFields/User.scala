package Chaptor04_ClassAndFields

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class User(val id: Int) {
	var name: String = _
	var gender: String = _
	private var married: Boolean = _
	
	override def toString: String = s"user: [id=$id, name=$name, gender=$gender, married=$married]"
	
}


object TestUser extends App {
	
	val user: User = new User(9527)
	user.gender = "male"
	user.name = "tangbohu"
//	user.married = true	// 这里无法调用 user 的 setter 方法. 因为该属性用 private 修饰, 那么该属性默认的 getter/setter 方法对于伴生类和伴生对象外不提供访问权限.
	println(user)		// user: [id=9527, name=tangbohu, gender=male, married=false]
	
}

/**
	package Chaptor04_ClassAndFields;
	import scala.reflect.ScalaSignature;

	@ScalaSignature(bytes = "\006\001%3AAD\b\001%!A\021\004\001BC\002\023\005!\004\003\005\037\001\t\005\t\025!\003\034\021\025y\002\001\"\001!\021%!\003\0011AA\002\023\005Q\005C\0052\001\001\007\t\031!C\001e!I\001\b\001a\001\002\003\006KA\n\005\ns\001\001\r\0211A\005\002\025B\021B\017\001A\002\003\007I\021A\036\t\023u\002\001\031!A!B\0231\003\"\003 \001\001\004\005\r\021\"\003@\021%\031\005\0011AA\002\023%A\tC\005G\001\001\007\t\021)Q\005\001\")q\t\001C!\021\n!Qk]3s\025\005\001\022\001G\"iCB$xN\035\0315?\016c\027m]:B]\0224\025.\0327eg\016\0011C\001\001\024!\t!r#D\001\026\025\0051\022!B:dC2\f\027B\001\r\026\005\031\te.\037*fM\006\021\021\016Z\013\0027A\021A\003H\005\003;U\0211!\0238u\003\rIG\rI\001\007y%t\027\016\036 \025\005\005\032\003C\001\022\001\033\005y\001\"B\r\004\001\004Y\022\001\0028b[\026,\022A\n\t\003O9r!\001\013\027\021\005%*R\"\001\026\013\005-\n\022A\002\037s_>$h(\003\002.+\0051\001K]3eK\032L!a\f\031\003\rM#(/\0338h\025\tiS#\001\005oC6,w\fJ3r)\t\031d\007\005\002\025i%\021Q'\006\002\005+:LG\017C\0048\013\005\005\t\031\001\024\002\007a$\023'A\003oC6,\007%\001\004hK:$WM]\001\013O\026tG-\032:`I\025\fHCA\032=\021\0359\004\"!AA\002\031\nqaZ3oI\026\024\b%A\004nCJ\024\030.\0323\026\003\001\003\"\001F!\n\005\t+\"a\002\"p_2,\027M\\\001\f[\006\024(/[3e?\022*\027\017\006\0024\013\"9qgCA\001\002\004\001\025\001C7beJLW\r\032\021\002\021Q|7\013\036:j]\036$\022A\n")
	public class User {
	
		private final int id;
 		private String name;
  		private String gender;
  		private boolean married;
		
		public int id() {
			return this.id;
		}
		
		public User(int id) {}
  
  		public String name() {
    		return this.name;
  		}
  
  		public void name_$eq(String x$1) {
    		this.name = x$1;
  		}
  
  		public String gender() {
    		return this.gender;
  		}
  
  		public void gender_$eq(String x$1) {
    		this.gender = x$1;
  		}
  
  		private boolean married() {
    		return this.married;
  		}
  
  		private void married_$eq(boolean x$1) {
    		this.married = x$1;
  		}
  
  		public String toString() {
    		return (new StringBuilder(37)).append("user: [id=").append(id()).append(", name=").append(name()).append(", gender=").append(gender()).append(", married=").append(married()).append("]").toString();
  		}
	}
 */

