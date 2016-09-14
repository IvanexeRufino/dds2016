package com.ddsutn.group01.tpanual.db;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListConverter implements AttributeConverter<List, String> {
    private static final String SEPARATOR = ", ";

    @Override
    @SuppressWarnings("unchecked")
    public String convertToDatabaseColumn(List list) {
        return String.join(SEPARATOR, (List<String>) list);
    }

    @Override
    public List convertToEntityAttribute(String stringJoined) {
        return new ArrayList<>(Arrays.asList(stringJoined.split(SEPARATOR)));
    }
}
