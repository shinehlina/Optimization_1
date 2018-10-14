package min_search_functions.unimodal_function_segment;

import main.Main;

public class GoldenSection {
    public static double findMin(double e, double a, double b) {
        double x1, x2;
        final double gs1 = (3 - Math.sqrt(5)) / 2;
        final double gs2 = (Math.sqrt(5) - 1) / 2;
        while (true) {
            x1 = a + gs1 * (b - a);
            x2 = a + gs2 * (b - a);
            if (Main.func(x1) >= Main.func(x2))
                a = x1;
            else
                b = x2;
            if (Math.abs(b - a) < e)
                break;
        }
        return (a + b) / 2;
    }
}

