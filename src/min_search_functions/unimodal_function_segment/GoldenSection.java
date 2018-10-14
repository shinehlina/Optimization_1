package min_search_functions.unimodal_function_segment;

import main.Main;

public class GoldenSection {
    /*
    Преимущество этого метода заключается в том, что одна из точек уже посчитана и не нужно считать обе.
    Однако, если не считать руками, быстрее и проще каждый раз считать заново.
    Иначе приходится добавлять условие, запоминать в какую сторону сдвинулись границы (x1 или x2 уже посчитан?)
    TODO: добавить время
     */
    public static double findMin(double e, double a, double b) {
        double x1, x2;
        final double gs = (Math.sqrt(5) + 1) / 2;
        x1 = b - (b - a) / gs;
        x2 = a + (b - a) / gs;
        while (true) {
            if (Main.func(x1) >= Main.func(x2)) {
                a = x1;
                x1 = x2;
                x2 = a + (b - a) / gs;
            }
            else {
                b = x2;
                x2 = x1;
                x1 = b - (b - a ) / gs;
            }
            if (Math.abs(b - a) < e)
                break;
        }
        return (a + b) / 2;
    }
}

