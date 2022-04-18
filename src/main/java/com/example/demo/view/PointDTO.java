package com.example.demo.view;

import com.example.demo.model.Point;

public class PointDTO extends Point {
    public PointDTO(double x, double y) {
        super(x, y);
    }

    public String getXStr() {
        return String.format("%5.1f", getX());
    }

    public String getYStr() {
        return String.format("%5.3f", getY());
    }

}
