package com.ddsutn.group01.tpanual.InterpreterJSON;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class InterpreterJSON {
    static ObjectMapper mapper = new ObjectMapper();
    
    public static List<Integer> getListaDePOIs(String unString) throws Exception{
        BajaDePOIDTO unDTO;
        unDTO = mapper.readValue(unString, BajaDePOIDTO.class);
        return unDTO.getPuntos();
    }
}
