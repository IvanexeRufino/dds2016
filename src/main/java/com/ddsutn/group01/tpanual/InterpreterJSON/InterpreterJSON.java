package com.ddsutn.group01.tpanual.InterpreterJSON;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

public class InterpreterJSON {
    
    static public ArrayList<Integer> getListaDePOIs(String unString) {
        BajaDePOIDTO unDTO;
        ObjectMapper mapper = new ObjectMapper();
        try {
        unDTO = mapper.readValue(unString, BajaDePOIDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return unDTO.getListDePOIs();
    }
}
