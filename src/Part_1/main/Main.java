package Part_1.main;

import Part_1.min_search_functions.unimodal_function_segment.Dihotomia;
import Part_1.min_search_functions.unimodal_function_segment.Fibonacci;
import Part_1.min_search_functions.unimodal_function_segment.GoldenSection;

import java.util.Arrays;

public class Main {

    public static double func(double x) {
        return Math.cos(x);
    }

    public static double func2(double x) {
        return x * x + x;
    }

    public static double func(Point a) {
        return Math.cos(a.get(0));
    }

    public static void main(String[] args) {
        FunctionF function = a -> Math.cos(a.get(0));
        System.out.println(Dihotomia.findMin(0.001, 3.14 / 2, 3.14 / 2 * 3));
        System.out.println(Dihotomia.findMin(0.001, 0, 3.14));
        System.out.println(Dihotomia.findMultidimensionalMin(0.001F, new Point(Arrays.asList(3.14F / 2, 0F)), new Point(Arrays.asList(3.14F / 2 * 3, 0F)), function));
        System.out.println(Dihotomia.findMultidimensionalMin(0.001F, new Point(Arrays.asList(0F, 0F)), new Point(Arrays.asList(3.14F, 0F)), function));

        System.out.println(GoldenSection.findMin(0.001, 3.14 / 2, 3.14 / 2 * 3));
        System.out.println(GoldenSection.findMin(0.001, 0, 3.14));
        System.out.println(GoldenSection.findMultidimensionalMin(0.001F, new Point(Arrays.asList(3.14F / 2, 0F)), new Point(Arrays.asList(3.14F / 2 * 3, 0F)), function));
        System.out.println(GoldenSection.findMultidimensionalMin(0.001F, new Point(Arrays.asList(0F, 0F)), new Point(Arrays.asList(3.14F, 0F)), function));

        System.out.println(Fibonacci.findMin(0.001, 3.14 / 2, 3.14 / 2 * 3));
        System.out.println(Fibonacci.findMin(0.001, 0, 3.14));
        System.out.println(Fibonacci.findMultidimensionalMin(0.001F, new Point(Arrays.asList(3.14F / 2, 0F)), new Point(Arrays.asList(3.14F / 2 * 3, 0F)), function));
        System.out.println(Fibonacci.findMultidimensionalMin(0.001F, new Point(Arrays.asList(0F, 0F)), new Point(Arrays.asList(3.14F, 0F)), function));



    }

}
