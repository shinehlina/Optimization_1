package Part_1.main;

import java.util.ArrayList;
import java.util.List;

public class Point {
    private List<Float> values;

    public Point(List<Float> values) {
        this.values = values;
    }

    private Point() {
        values = new ArrayList<>();
    }

    public static Point minus(Point minuend, Point subtrahend) {
        if (minuend.size() != subtrahend.size()) {
            throw new IllegalArgumentException("Point are not compatible");
        }
        Point rez = new Point();
        for (int i = 0; i < minuend.size(); i++) {
            rez.values.add(minuend.get(i) - subtrahend.get(i));
        }
        return rez;
    }

    public static Point minus(Point minuend, Vector subtrahend) {
        return minus(minuend, subtrahend.end);
    }

    public static Point plus(Point first, Point second) {
        if (first.size() != second.size()) {
            throw new IllegalArgumentException("Point are not compatible");
        }
        Point rez = new Point();
        for (int i = 0; i < first.size(); i++) {
            rez.add(first.get(i) + second.get(i));
        }
        return rez;
    }

    public static Point plus(Point first, Vector second) {
        return plus(first, second.end);
    }

    /*
    finds distance between 2 points
     */
    public static float findDistance(Point a, Point b) {
        float distance;
        float sum = 0F;
        for (int i = 0; i < a.size(); i++) {
            sum += (a.get(i) - b.get(i)) * (a.get(i) - b.get(i));
        }
        distance = (float) Math.sqrt(sum);
        return distance;
    }

    public static Point divide(Point a, float length) {
        Point result = new Point();
        for (int i = 0; i < a.values.size(); i++) {
            result.values.add(i, a.values.get(i) / length);
        }
        return result;
    }

    public static Point findMiddle(Point left, Point right) {
        return divide(plus(right, left), 2.0F);
    }

    public static Point multiply(Point a, float b) {
        Point result = new Point();
        for (int i = 0; i < a.size(); i++) {
            result.values.add(i, a.get(i) * b);
        }
        return result;
    }

    public Float get(int index) {
        return values.get(index);
    }

    int size() {
        return values.size();
    }

    public void set(int index, float value) {
        values.set(index, value);
    }

    public void add(float value) {
        values.add(value);
    }

    @Override
    public String toString() {
        return "Point{" +
                "values=" + values +
                '}';
    }
}
