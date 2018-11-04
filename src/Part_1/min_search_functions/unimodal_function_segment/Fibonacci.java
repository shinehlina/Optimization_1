package Part_1.min_search_functions.unimodal_function_segment;

import Part_1.main.Main;
import Part_1.main.Point;

public class Fibonacci {

    private static final int MAX_SIZE = 91; //порядковый номер максимально возможного числа фиббоначи, который может поместиться в long

    /*
    Формула Бинэ может с какого-то n будет не точна, так как вычислить sqrt(5) на ЭВМ точно нельзя.
    Из-за этого  используется классический способ вычисления числа Фибоначчи
     */

    private static long fibonacciFunc(int n) {
        if (n >= MAX_SIZE) {
            String errorMessage = "Long overflow, the Fibonacci number is too big. Try with a bigger error";
            throw new IllegalArgumentException(errorMessage);
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciFunc(n - 1) + fibonacciFunc(n - 2);
    }

    private static int findIterationNumber(double e, double a, double b) {
        int n = 0;
        while ((b - a) / e >= fibonacciFunc(n + 2)) {
            n++;
        }
        return n;
    }

    private static int findIterationNumber(float e, Point a, Point b) {
        int n = 0;
        while (Point.findDistance(a, b) / e >= fibonacciFunc(n + 2)) {
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
            if (Main.func(x1) < Main.func(x2)) {
                b = x2;
                x2 = x1;
                x1 = a + (b - x2);
            } else {
                a = x1;
                x1 = x2;
                x2 = b - (x1 - a);
            }
            n--;
        }
        return (a + b) / 2;
    }

    public static Point findMultidimensionalMin(float e, Point a, Point b) {
        int n = findIterationNumber(e, a, b);
        Point x1, x2;
        x1 = Point.plus(a, Point.multiply(Point.minus(b, a), (float) fibonacciFunc(n) / fibonacciFunc(n + 2)));
        x2 = Point.plus(a, Point.multiply(Point.minus(b, a), (float) fibonacciFunc(n + 1) / fibonacciFunc(n + 2)));
        while (n > 0) {
            if (Main.func(x1) < Main.func(x2)) {
                b = x2;
                x2 = x1;
                x1 = Point.plus(a, Point.minus(b, x2));
            } else {
                a = x1;
                x1 = x2;
                x2 = Point.minus(b, Point.minus(x1, a));
            }
            n--;
        }
        return Point.findMiddle(a, b);
    }
}
