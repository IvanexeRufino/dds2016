package com.ddsutn.group01.tpanual.InterpreterJSON;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.List;

public class InterpreterJSON {
    static ObjectMapper mapper = new ObjectMapper();

    public static List<Integer> getListaDePOIs(String unString) throws Exception {
        BajaDePOIDTO unDTO;
        unDTO = mapper.readValue(unString, BajaDePOIDTO.class);
        return unDTO.getPuntos();
    }
}
