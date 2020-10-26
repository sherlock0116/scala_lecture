package cgs.java;

import java.util.HashSet;

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
public class TestSingleTon {

    public static void main(String[] args) {

        SingleTon s1 = SingleTon.getInstance();
        SingleTon s2 = SingleTon.getInstance();

        System.out.printf("SingleTon 实现了单例模式: [%b]\n", s1 == s2);

        String str1 = "hello";
        String str2 = new String("hello");
        String str3 = "hello";
        System.out.println(str1 == str2);               // false
        System.out.println(str1 == str3);               // true
        System.out.println(str1.equals(str2));      // true
        System.out.println(str1.equals(str3));      // true

        System.out.println(str1.hashCode() == str2.hashCode());     // true
        System.out.println(str1.hashCode() == str3.hashCode());     // true

        HashSet set = new HashSet();
        for (int i = 0; i < 10; i++) {
            set.add(new String("hello"));
        }
        System.out.println(set.size());     // 结果为 1, 因为 String类重写了 equals 和 hashcode 方法


    }
}
