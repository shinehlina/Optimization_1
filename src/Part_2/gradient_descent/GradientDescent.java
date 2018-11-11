package Part_2.gradient_descent;

import Part_1.main.FunctionF;
import Part_1.main.Point;
import Part_1.main.Vector;
import Part_1.min_search_functions.Straight;
import Part_1.min_search_functions.unimodal_function_segment.GoldenSection;
import Part_2.GradientFunction;
import javafx.util.Pair;

public class GradientDescent {
    public static Point findMin(Point startPoint, float precision, FunctionF function, GradientFunction grad) {
        Vector direction = Vector.opposite(grad.gradient(startPoint));
        direction.normalize();
        Point previous = startPoint;
        Pair<Point, Point> segment = Straight.findSegment(startPoint, direction, function);
        Point x = GoldenSection.findMultidimensionalMin(precision, segment.getKey(), segment.getValue(), function);
        while (Math.abs(Point.findDistance(x, previous)) > precision) {
            previous = x;
            direction = Vector.opposite(grad.gradient(previous));
            direction.normalize();
            segment = Straight.findSegment(previous, direction, function);
            x = GoldenSection.findMultidimensionalMin(precision, segment.getKey(), segment.getValue(), function);
        }
        return x;
    }
}
