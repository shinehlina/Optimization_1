package Part_2.main;

import Part_1.main.FunctionF;
import Part_1.main.Point;
import Part_1.main.Vector;
import Part_2.GradientFunction;
import Part_2.gradient_descent.GradientDescent;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        Point startpoint1 = new Point(Arrays.asList(0.0f, 0.0f));
        Point startpoint2 = new Point(Arrays.asList(10.0f, 0.0f));
        Point startpoint3 = new Point(Arrays.asList(10.0f, 10.0f));
        Point startpoint4 = new Point(Arrays.asList(0.0f, 10.0f));
        FunctionF functionF = a -> {
            float x = a.get(0);
            float y = a.get(1);
            return (y - x * x) * (y - x * x) + (1 - x) * (1 - x);
        };
        GradientFunction grad = a -> {
            float x = a.get(0);
            float y = a.get(1);
            float fx = -4 * (y - x * x) * x - 2 * (1 - x);
            float fy = 2 * (y - x * x);
            return new Vector(new Point(Arrays.asList(fx, fy)));
        };

        System.out.println(GradientDescent.findMin(startpoint1, 0.1f, functionF, grad));
//        System.out.println(GradientDescent.findMin(startpoint2, 0.01f, functionF, grad));
//        System.out.println(GradientDescent.findMin(startpoint3, 0.1f, functionF, grad));
//        System.out.println(GradientDescent.findMin(startpoint4, 0.01f, functionF, grad));
    }
}
