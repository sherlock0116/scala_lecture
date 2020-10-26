package cgs.test.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */


public class JUnitTest {

    @Test
    public void test_generics_eraser() {
        List<String> a = new ArrayList<String>();
        List<Integer> b = new ArrayList<Integer>();
        System.out.println(a.getClass() == b.getClass());
    }
}
