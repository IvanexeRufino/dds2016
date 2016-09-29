package com.ddsutn.group01.tpanual.db;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringListConverter implements AttributeConverter<List, String> {
    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(List list) {
        if (list == null) {
            return null;
        }

        return String.join(SEPARATOR, (List<String>) list);
    }

    @Override
    public List convertToEntityAttribute(String stringJoined) {
        if (stringJoined == null) {
            return null;
        }

        return new ArrayList<>(Arrays.asList(stringJoined.split(SEPARATOR)));
    }
}
