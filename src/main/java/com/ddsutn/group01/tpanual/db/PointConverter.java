package com.ddsutn.group01.tpanual.db;

import org.uqbar.geodds.Point;

import javax.persistence.AttributeConverter;

public class PointConverter implements AttributeConverter<Point, String> {
    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(Point point) {
        if (point == null) {
            return null;
        }

        return point.latitude() + SEPARATOR + point.longitude();
    }

    @Override
    public Point convertToEntityAttribute(String pointString) {
        if (pointString == null) {
            return null;
        }

        String[] coordinates = pointString.split(SEPARATOR);

        return new Point(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
    }
}
