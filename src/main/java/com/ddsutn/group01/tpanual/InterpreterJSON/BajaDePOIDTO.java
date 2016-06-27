package com.ddsutn.group01.tpanual.InterpreterJSON;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class BajaDePOIDTO {
    private ArrayList<Integer> listDePOIs;
    private DateTime unaFecha;
    
    public ArrayList<Integer> getListDePOIs() {
        return listDePOIs;
    }
    public void setListDePOIs(ArrayList<Integer> listDePOIs) {
        this.listDePOIs = listDePOIs;
    }
    public DateTime getUnaFecha() {
        return unaFecha;
    }
    public void setUnaFecha(DateTime unaFecha) {
        this.unaFecha = unaFecha;
    } 
    
}
