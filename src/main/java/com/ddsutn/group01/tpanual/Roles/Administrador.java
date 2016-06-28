//package com.ddsutn.group01.tpanual.Roles;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.ddsutn.group01.tpanual.Procesos.Proceso;
//
//public class Administrador {
//    private List<Proceso> listaDeProcesos = new ArrayList<Proceso>();
//    
//    public void agregarProceso(Proceso unProceso) {
//        listaDeProcesos.add(unProceso);
//    }
//    
//    public void ejecutar() {
//        listaDeProcesos.stream().forEach(proceso->proceso.activarProceso());
//    }
//    
//}