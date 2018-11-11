package Part_1.min_search_functions;

import Part_1.main.FunctionF;
import Part_1.main.Main;
import Part_1.main.Point;
import Part_1.main.Vector;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Straight {
    public static ArrayList<Double> findMin() {
        double e = 0.01;
        double x, h, x1;
        double x0 = new Random().nextDouble();
        if (Main.func2(x0) > Main.func2(x0 + e)) {
            x = x0 + e;
            h = e;
        } else {
            x = x0 - e;
            h = -e;
        }
        while (true) {
            h *= 2;
            x1 = x + h;
            if ((Main.func2(x) - Main.func2(x1)) < e) {
//                return x - h / 2 < x1 ? new ArrayList<Double>(Arrays.asList(x - h / 2, x1)) : new ArrayList<>(Arrays.asList(x1, x - h / 2));
                return h > 0 ? new ArrayList<>(Arrays.asList(x - h / 2, x1)) : new ArrayList<>(Arrays.asList(x1, x - h / 2));
            }
            x = x1;
        }
    }

    // переписанная влада
    public static Pair<Point, Point> findSegment(Point startPoint, Vector direction, FunctionF function) {
        Point x = startPoint;
        Point left = Point.minus(x, direction);
        Point right = Point.plus(x, direction);
        double fm = function.function(x);
        double fr = function.function(right);
        double fl = function.function(left);
        if (fm > fr) {
            do {
                left = x;
                x = right;
                fm = fr;
                right = Point.plus(right, direction);
                fr = function.function(right);
            } while (fm > fr);
            return new Pair<>(right, left);
        }
        if (fm > fl) {
            do {
                right = x;
                x = left;
                fm = fl;
                left = Point.minus(left, direction);
                fl = function.function(left);
            } while (fm > fl);
            return new Pair<>(right, left);
        }
        return new Pair<>(left, right);
    }

    // моя версия
    //    public static Pair<Point, Point> findSegment(Point x0, Vector direction, float e, FunctionF function){
//        Point x, x1;
//        Vector h;
//        if (function.function(x0) > function.function(Point.plus(x0, Point.multiply(direction.getEnd(), e)))){
//            x = Point.plus(x0, Point.multiply(direction.getEnd(), e));
//            h = Vector.multiply(direction, e * 2);
//        } else {
//            x = Point.minus(x0, Point.multiply(direction.getEnd(), e));
//            h = Vector.opposite(Vector.multiply(direction, e * 2));
//        }
//        x1 = Point.plus(x, h);
//
//        do  {
//            h = Vector.multiply(h, 2);
//            Point t = x;
//            x = x1;
//            x1 = Point.plus(x, h);
//            x0 = t;
//        } while ((function.function(x) - function.function(x1)) > e);
//        return new Pair<>(x0, x1);
//    }

}
