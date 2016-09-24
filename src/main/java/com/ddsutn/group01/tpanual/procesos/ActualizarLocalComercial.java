package com.ddsutn.group01.tpanual.procesos;

public class ActualizarLocalComercial extends Proceso {
    private String bigstring;
    private Fileitor fileitor;

    public ActualizarLocalComercial(String bigstring) {
        this.bigstring = bigstring;
    }

    public int ejecutar() throws Exception {
        this.fileitor = new Fileitor(bigstring);
        fileitor.ejecutar();
        return 0;
    }
}
