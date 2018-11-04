package Part_1.min_search_functions.unimodal_function_segment;

import Part_1.main.Main;
import Part_1.main.Point;

public class GoldenSection {
    private final static float gs = (float) (Math.sqrt(5) + 1) / 2;

    /*
    TODO: добавить время
     */
    public static double findMin(double e, double a, double b) {
        double x1, x2;
        x1 = b - (b - a) / gs;
        x2 = a + (b - a) / gs;
        while (Math.abs(b - a) >= e) {
            if (Main.func(x1) >= Main.func(x2)) {
                a = x1;
                x1 = x2;
                x2 = a + (b - a) / gs;
            } else {
                b = x2;
                x2 = x1;
                x1 = b - (b - a) / gs;
            }
        }
        return (a + b) / 2;
    }

    public static Point findMultidimensionalMin(float e, Point a, Point b) {
        Point x1, x2;
        x1 = Point.minus(b, Point.divide(Point.minus(b, a), gs));
        x2 = Point.plus(a, Point.divide(Point.minus(b, a), gs));
        while (Point.findDistance(a, b) >= e) {
            if (Main.func(x1) >= Main.func(x2)) {
                a = x1;
                x1 = x2;
                x2 = Point.plus(a, Point.divide(Point.minus(b, a), gs));
            } else {
                b = x2;
                x2 = x1;
                x1 = Point.minus(b, Point.divide(Point.minus(b, a), gs));
            }
        }
        return Point.findMiddle(a, b);
    }
}

