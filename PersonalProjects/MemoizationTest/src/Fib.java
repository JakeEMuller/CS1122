
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Arrays;

public class Fib {

    public long f(long n) {
        if (n < 2) return n;
        return f(n - 1) + f(n - 2);
    }

    public long fib(long n) {
        ArrayList<Long> list = new ArrayList<>(Arrays.asList(0L, 1L));
        return fib(n, list);
    }

    private long fib(long n, ArrayList<Long> list) {
        if (list.size() > n) {
            return list.get((int) n);
        }
        long result = fib(n - 1, list) + fib(n - 2, list);
        list.add(result);
        return result;
    }

    public static void main(String[] args) {
        Fib obj = new Fib();
        long start = System.nanoTime();
        long result = obj.fib(50);
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("calculates fib result in " + duration + " nano seconds");
        System.out.println(result);
        start = System.nanoTime();
        result = obj.f(50);
        end = System.nanoTime();
        duration = end - start;
        System.out.println("calculates f result in " + duration + " nano seconds");
        System.out.println(result);
    }
}
