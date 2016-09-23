package com.ddsutn.group01.tpanual.db;

import com.ddsutn.group01.tpanual.models.Horario;
import org.joda.time.LocalTime;

import javax.persistence.AttributeConverter;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HorariosConverter implements AttributeConverter<List, String> {
    private static final String SEPARATOR = ", ";
    private static final String ITEM_SEPARATOR = "-";

    @Override
    public String convertToDatabaseColumn(List list) {

        List<Horario> horarios = (List<Horario>) list;
        List<String> result = horarios.stream().map(horario -> {
            StringBuilder sb = new StringBuilder();
            sb.append(horario.getDia().toString());
            sb.append(ITEM_SEPARATOR);
            sb.append(horario.getHoraDeApertura());
            sb.append(ITEM_SEPARATOR);
            sb.append(horario.getHoraDeCierre());

            return sb.toString();
        }).collect(Collectors.toList());

        return String.join(SEPARATOR, result);
    }

    @Override
    public List convertToEntityAttribute(String string) {
        List<String> horarios = new ArrayList<> (Arrays.asList(string.split(SEPARATOR)));

        return horarios.stream().map(horario -> {
            String[] horariosParts = horario.split(ITEM_SEPARATOR);
            DayOfWeek dia = DayOfWeek.valueOf(horariosParts[0]);
            LocalTime horaDeApertura = LocalTime.parse(horariosParts[1]);
            LocalTime horaDeCierre = LocalTime.parse(horariosParts[2]);

            return new Horario(dia, horaDeApertura, horaDeCierre);
        }).collect(Collectors.toList());
    }
}
