package Part_1.min_search_functions.unimodal_function_segment;

import Part_1.main.Main;
import Part_1.main.NormalizedMathVector;
import Part_1.main.Point;

public class Dihotomia {
    /*
    TODO: добавить время
     */
    public static double findMin(double e, double a, double b) {
        double x, x1, x2, fx1, fx2;
        while (Math.abs(b - a) >= e) {
            x = (a + b) / 2;
            x1 = x - e / 3;
            x2 = x + e / 3;
            fx1 = Main.func(x1);
            fx2 = Main.func(x2);
            if (fx1 < fx2) {
                b = x2;
            } else {
                a = x1;
            }
        }
        return (a + b) / 2;
    }

    public static Point findMultidimensionalMin(float e, Point a, Point b) {
        NormalizedMathVector direction = new NormalizedMathVector(a, b);
        Point x, x1, x2;
        double fx1, fx2;
        while (Point.findDistance(a, b) >= e) {
            x = Point.findMiddle(a, b);
            x1 = Point.minus(x, NormalizedMathVector.multiply(direction, e / 3));
            x2 = Point.plus(x, NormalizedMathVector.multiply(direction, e / 3));
            fx1 = Main.func(x1);
            fx2 = Main.func(x2);
            if (fx1 < fx2) {
                b = x2;
            } else {
                a = x1;
            }
        }
        return Point.findMiddle(a, b);
    }
}
