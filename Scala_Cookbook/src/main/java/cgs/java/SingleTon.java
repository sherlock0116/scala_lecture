package cgs.java;

/**
 * @Description TODO
 * @Author sherlock
 * @Date
 */
public class SingleTon {

    private SingleTon() {
        // private
    }

    private static class SingleTonHoler {
        private static final SingleTon INSTANCE = new SingleTon();
    }

    public static SingleTon getInstance() {
        return SingleTonHoler.INSTANCE;
    }
}
