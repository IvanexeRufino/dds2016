package com.ddsutn.group01.tpanual.adapters.Banco;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;

class MapperDeBancos {
    static ObjectMapper mapper = new ObjectMapper();
    
    static BancoDTO mappear(String unString) {
        BancoDTO unDTO = new BancoDTO();
        try {
          unDTO = mapper.readValue(unString, BancoDTO.class);
        } catch (IOException e) {
        }
        return unDTO;
    }   
}