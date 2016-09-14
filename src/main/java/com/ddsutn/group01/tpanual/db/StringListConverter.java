package com.ddsutn.group01.tpanual.db;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringListConverter implements AttributeConverter<List<String>, String> {
    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(List<String> list) {
        return String.join(SEPARATOR, list);
    }

    @Override
    public List<String> convertToEntityAttribute(String stringJoined) {
        return new ArrayList<>(Arrays.asList(stringJoined.split(SEPARATOR)));
    }
}