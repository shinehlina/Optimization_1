package min_search_functions.unimodal_function_segment;

import main.Main;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    static int SIZE = 92;

    private static List<Long> fibNumbers = new ArrayList<>();

    static {
        fibNumbers.add(0, 0L);
        fibNumbers.add(1, 1L);
        for (int i = 2; i < SIZE; i++) {
            fibNumbers.add(i, fibNumbers.get(i - 1) + fibNumbers.get(i - 2));
        }
    }

    /*
    Формула Бинэ может с какого-то n будет не точна, так как вычислить sqrt(5) на ЭВМ точно нельзя.
    Из-за этого здесь используется классический способ вычисления числа Фибоначчи
     */

    private static long fibonacciFunc(int n) {
        if(n >= 92) {
            String errorMessage = "Long overflow, the Fibonacci number is too big. Try with a bigger error";
            throw new IllegalArgumentException(errorMessage);
        }
        if (n < SIZE) {
            return fibNumbers.get(n);
        }
        long fib = fibonacciFunc(n - 1) + fibonacciFunc(n - 2);
        fibNumbers.add(n, fib);
        return fib;
    }

    private static int findIterationNumber(double e, double a, double b) {
        int n = 0;
        while ((a + b) / e >= fibonacciFunc(n + 2)) {
            n++;
        }
        return n;
    }

    public static double findMin(double e, double a, double b) {
        int n = findIterationNumber(e, a, b);
        double x1, x2;
        x1 = a + ((double) fibonacciFunc(n) / fibonacciFunc(n + 2)) * (b - a);
        x2 = a + ((double) fibonacciFunc(n + 1) / fibonacciFunc(n + 2)) * (b - a);
        while (n > 0) {
            double f1 = Main.func(x1);
            double f2 = Main.func(x2);
            if (f1 < f2){
                b = x2;
                x2 = x1;
                x1 = a + (b - x2);
            }
            else {
                a = x1;
                x1 = x2;
                x2 = b - (x1 - a);
            }
            n--;
        }
        return (a + b) / 2;
    }
}
