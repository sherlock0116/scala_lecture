package Chaptor04_WorkingWithObjects

import scala.beans.BeanProperty

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class Dude(@BeanProperty val firstName: String, val lastName: String) {
	
	@BeanProperty var position: String = _
}

/*
上面这段代码使用 scalac 编译后,再使用 javap -private Dude 查看编译器所生成的代码如下

Complied from "Dude.scala"
public class Dude {
	
	private final String firstName;
	private final String lastName;
	private String position;
	
	public String firstName();
	public String lastName();
	public String position();
	
	public void position_$eq(String);
	public void setPosition(String);
	
	public String getFirstName();
	public String getPosition();
	
	public Dude(String, String)
}
 */