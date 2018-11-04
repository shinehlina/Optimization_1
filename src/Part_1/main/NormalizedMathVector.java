package Part_1.main;

public class NormalizedMathVector {
    private Point end;

    public NormalizedMathVector(Point first, Point second) {
        float length = Point.findDistance(first, second);
        end = Point.minus(second, first);
        end = Point.divide(end, length);
    }

    public static Point multiply(NormalizedMathVector victor, float a) {
        return Point.multiply(victor.end, a);
    }
}
