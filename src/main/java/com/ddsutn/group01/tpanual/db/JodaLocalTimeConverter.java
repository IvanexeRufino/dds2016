package com.ddsutn.group01.tpanual.db;

import org.joda.time.LocalTime;
import org.mongodb.morphia.converters.SimpleValueConverter;
import org.mongodb.morphia.converters.TypeConverter;
import org.mongodb.morphia.mapping.MappedField;
import org.mongodb.morphia.mapping.MappingException;

public class JodaLocalTimeConverter extends TypeConverter implements SimpleValueConverter {

    public JodaLocalTimeConverter() {
        super(LocalTime.class);
    }

    @Override
    public Object decode(Class targetClass, Object fromDBObject, MappedField optionalExtraInfo) throws MappingException {
        if (fromDBObject == null) {
            return null;
        }

        if (fromDBObject instanceof String) {
            String str = (String) fromDBObject;
            return new LocalTime(str);
        }

        throw new RuntimeException(
            "Did not expect " + fromDBObject.getClass().getName());
    }

    @Override
    public Object encode(Object value, MappedField optionalExtraInfo) {
        if (value == null) {
            return null;
        }

        if (!(value instanceof LocalTime)) {
            throw new RuntimeException(
                "Did not expect " + value.getClass().getName());
        }

        LocalTime localTime = (LocalTime) value;
        return localTime.toString();
    }

}
