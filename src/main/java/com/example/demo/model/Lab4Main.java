package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class Lab4Main {
    public static void main(String[] args) {
        new Lab4Main().run();
    }

    private void run() {

    }

    public List<Point> tabulate(double a, double b, double h, DoubleUnaryOperator f) {
        int n = (int) (Math.round((b-a)/h)+1);
        List<Point> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double x = a + i * h;
            double y = f.applyAsDouble(x);
            res.add(new Point(x,y));
        }
        return res;
    }

}
