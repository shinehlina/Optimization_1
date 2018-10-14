package min_search_functions.unimodal_function_segment;

import main.Main;

public class Dihotomia {
    public static double findMin(double e, double a, double b) {
        double x, x1, x2, fx1, fx2;
        while (true) {
            x = (a + b) / 2;
            x1 = x - e / 3;
            x2 = x + e / 3;
            fx1 = Main.func(x1);
            fx2 = Main.func(x2);
            if (fx1 < fx2) {
                b = x2;
            } else if (fx1 > fx2) {
                a = x1;
            } else if (Math.abs(fx1 - fx2) < e){
                a = x1;
                b = x2;
                break;
            }
        }
        return (a + b) / 2;
    }
}
