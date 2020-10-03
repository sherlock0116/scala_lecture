package Chaptor04_WorkingWithObjects

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
class CreditCard(val number: Int, var creditLimit: Int)

/*
上面这段代码使用 scalac 编译后,再使用 javap -private CreditCard 查看编译器所生成的代码如下

Complied from "CreditCard.scala"
public class CredutCard {
	private final int number;
	private int creditLimit;
	
	public int number();
	public int creditLimit();
	
	public void creditLimit_$eq(int);
	public CreditCard (int, int)
	
}

Scala 自动将 val 修饰的字段加了 private final
而且还为我们生成了相应的 getter/setter 方法
默认的 getter/setter 方法并不遵循 JavaBean 的惯例
 */