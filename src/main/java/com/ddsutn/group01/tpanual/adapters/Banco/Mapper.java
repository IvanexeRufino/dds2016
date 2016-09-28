package com.ddsutn.group01.tpanual.adapters.Banco;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.ddsutn.group01.tpanual.adapters.CGP.CentroDTO;

public class Mapper {
    static ObjectMapper mapper = new ObjectMapper();
    
    public static List<BancoDTO> mappearBanco(String unString) {
        List<BancoDTO> unDTO;
        try {
          unDTO = mapper.readValue(unString, new TypeReference<List<BancoDTO>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return unDTO;
    }  
    
    public static List<CentroDTO> mappearCGP(String unString) {
        List<CentroDTO> unDTO;
        System.out.println(unString);
        try {
          unDTO = mapper.readValue(unString, new TypeReference<List<CentroDTO>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return unDTO;
    }
    
    public static String obtenerJSONDelCGP(List<CentroDTO> result) {
    	String JSON;
    	try {
    		JSON = mapper.writeValueAsString(result);
    	} catch (IOException e) {
    		throw new RuntimeException(e);
    	}
    	return JSON;
    }
}