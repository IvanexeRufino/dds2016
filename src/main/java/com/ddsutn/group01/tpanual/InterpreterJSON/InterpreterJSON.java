package com.ddsutn.group01.tpanual.InterpreterJSON;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class InterpreterJSON {
    static ObjectMapper mapper = new ObjectMapper();
    
    public static List<Integer> getListaDePOIs(String unString) {
        BajaDePOIDTO unDTO;
        try {
        unDTO = mapper.readValue(unString, BajaDePOIDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return unDTO.getPuntos();
    }
}
