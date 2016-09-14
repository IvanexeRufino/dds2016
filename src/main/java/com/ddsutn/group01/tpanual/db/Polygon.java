package com.ddsutn.group01.tpanual.db;

import org.uqbar.geodds.Point;

import java.util.List;

public class Polygon extends org.uqbar.geodds.Polygon {
    public Polygon() {
    }

    public Polygon(List<Point> points) {
        super(points);
    }


    public List<Point> getPoints() {
        return this.surface;
    }
}
