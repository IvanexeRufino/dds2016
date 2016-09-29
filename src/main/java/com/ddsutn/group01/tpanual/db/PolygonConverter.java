package com.ddsutn.group01.tpanual.db;

import org.uqbar.geodds.Point;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PolygonConverter implements AttributeConverter<Polygon, String> {
    private static final String SEPARATOR = " - ";
    private static final String ITEM_SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(Polygon polygon) {
        if (polygon == null) {
            return null;
        }

        List<String> points = polygon.getPoints().stream().map(point -> {
            return (point.latitude() + ITEM_SEPARATOR + point.longitude());
        }).collect(Collectors.toList());

        return String.join(SEPARATOR, points);
    }

    @Override
    public Polygon convertToEntityAttribute(String polygonString) {
        if (polygonString == null) {
            return null;
        }

        List<String> pointsString = Arrays.asList(polygonString.split(SEPARATOR));

        List<Point> points = pointsString.stream().map(point -> {
            String[] coordinates = point.split(ITEM_SEPARATOR);
            return new Point(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
        }).collect(Collectors.toList());

        return new Polygon(points);
    }
}
