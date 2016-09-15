package com.ddsutn.group01.tpanual.Procesos.Filtradores;

import java.util.List;
import java.util.stream.Collectors;

import com.ddsutn.group01.tpanual.Roles.Terminal;

public class PorComuna implements FiltradorDeTerminales{
    
    private int comuna;
    
    public PorComuna (int comuna) {
        this.comuna = comuna;
    }

    @Override
    public List<Terminal> filtrar(List<Terminal> terminales) {
        return terminales.stream().filter(terminal -> terminal.getComuna() == comuna)
                                  .collect(Collectors.toList());
        
    }
    
    

}
