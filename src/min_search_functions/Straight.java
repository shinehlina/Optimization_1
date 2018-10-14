package min_search_functions;

import main.Main;

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
                return h > 0 ? new ArrayList<Double>(Arrays.asList(x - h / 2, x1)) : new ArrayList<>(Arrays.asList(x1, x - h / 2));
            }
            x = x1;
        }
    }
}
