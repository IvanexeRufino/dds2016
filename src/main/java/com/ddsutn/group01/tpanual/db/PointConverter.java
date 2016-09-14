package com.ddsutn.group01.tpanual.db;

import org.uqbar.geodds.Point;

import javax.persistence.AttributeConverter;

public class PointConverter implements AttributeConverter<Point, String> {
    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(Point point) {
        return point.latitude() + SEPARATOR + point.longitude();
    }

    @Override
    public Point convertToEntityAttribute(String pointString) {
        String[] coordinates = pointString.split(SEPARATOR);
        return new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
    }
}
