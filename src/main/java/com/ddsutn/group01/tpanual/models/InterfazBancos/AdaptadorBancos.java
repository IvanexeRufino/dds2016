package com.ddsutn.group01.tpanual.models.InterfazBancos;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;

public class AdaptadorBancos {
    public ArrayList<PointOfInterest> adaptar(ArrayList<String> unaListaDeString)
    {
        int i;
        ArrayList<PointOfInterest> puntosReales = new ArrayList<PointOfInterest>();
        ObjectMapper objectMapper = new ObjectMapper();
        //perdon por el for, pero si lo metia en el forEach era imposible hacer el try and catch para el error
        for(i=0;i<unaListaDeString.size();i=i+1){
        }
        try{
        CreadorDeBancos cdb = objectMapper.readValue(unaListaDeString.get(i), CreadorDeBancos.class);
        SucursalBanco sucursal = cdb.modelarBanco();
        puntosReales.add(sucursal);
        }catch (IOException e){
            e.printStackTrace();
        }
        return puntosReales;
        }
    }