package main;

import min_search_functions.Straight;
import min_search_functions.unimodal_function_segment.Dihotomia;
import min_search_functions.unimodal_function_segment.Fibonacci;
import min_search_functions.unimodal_function_segment.GoldenSection;

public class Main {

    public static double func(double x){
        return Math.cos(x);
    }

    public static double func2(double x) {return x * x + x;}

    public static void main(String[] args) {
        System.out.println(Dihotomia.findMin(0.001, 3.14 / 2, 3.14 / 2 * 3));
        System.out.println(Dihotomia.findMin(0.001, 0, 3.14));

        System.out.println(GoldenSection.findMin(0.001, 3.14 / 2, 3.14 / 2 * 3));
        System.out.println(GoldenSection.findMin(0.001, 0, 3.14));

        System.out.println(Fibonacci.findMin(0.001, 3.14 / 2, 3.14 / 2 * 3));
        System.out.println(Fibonacci.findMin(0.001, 0, 3.14));

        System.out.println(Straight.findMin());


    }

}
