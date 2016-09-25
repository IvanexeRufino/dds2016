package com.ddsutn.group01.tpanual.InterpreterJSON;

import java.util.List;

public class BajaDePOIDTO {
    private List<Integer> puntos;
    private String fecha;

    public List<Integer> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Integer> listDePOIs) {
        this.puntos = listDePOIs;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String unaFecha) {
        this.fecha = unaFecha;
    }

}
