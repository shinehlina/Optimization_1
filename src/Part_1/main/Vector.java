package Part_1.main;

import java.util.ArrayList;

public class Vector {
    Point end;

    public Vector() {
        end = new Point(new ArrayList<>());
    }

    public Vector(Point end) {
        this.end = end;
    }

    public Vector(Point first, Point second) {
        end = Point.minus(second, first);
    }

    public static Vector multiply(Vector victor, float a) {
        return new Vector(Point.multiply(victor.end, a));
    }

    public static Vector divide(Vector victor, float a) {
        return new Vector(Point.divide(victor.end, a));
    }

    public static Vector opposite(Vector victor) {
        Vector vector = new Vector();
        for (int j = 0; j < victor.end.size(); j++) {
            vector.end.add(-victor.end.get(j));
        }
        return vector;
    }

    public void normalize() {
        double sum = 0;
        for (int i = 0; i < end.size(); i++) {
            sum += end.get(i) * end.get(i);
        }
        float length = (float) Math.sqrt(sum);
        end = Point.divide(end, length);
    }

    public Point getEnd() {
        return end;
    }
}
