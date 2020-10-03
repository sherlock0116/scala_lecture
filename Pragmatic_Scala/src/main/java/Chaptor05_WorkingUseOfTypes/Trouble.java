package Chaptor05_WorkingUseOfTypes;

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */

class Fruit{}
class Banana extends Fruit{}
class Apple extends Fruit{}

public class Trouble {

    public static void main(String[] args) {

        Banana[] bananas = new Banana[2];
        bananas[0] = new Banana();

        Fruit[] fruits =  bananas;
        fruits[0] = new Apple();

        for (Banana banana: bananas) {
            System.out.println(banana);
        }
    }
}

/*
Exception in thread "main" java.lang.ArrayStoreException: Chaptor05_WorkingUseOfTypes.Apple
	at Chaptor05_WorkingUseOfTypes.Trouble.main(Trouble.java:21)

故障原因是, 运行时, 我们使用一篮子水果为托词,试图把一个苹果放进一篮子香蕉中
尽管异常发生在第 21 行, 但根本原因在于 Java 编译器没有在第 20 行阻止我们这样做

上述代码可以在编译器中溜过去, 不过为了公平起见, 它并不允许下面的代码通过编译
ArrayList<Integer> list = new ArrayList<Integer>();
ArrayList<Object> list1 = list;  // 编译错误

但遗憾的是我们可以很容易绕开这一限制:
ArrayList list2 = list;
 */