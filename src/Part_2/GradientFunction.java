package Part_2;

import Part_1.main.Point;
import Part_1.main.Vector;

@FunctionalInterface
public interface GradientFunction {
    Vector gradient(Point a);
}
