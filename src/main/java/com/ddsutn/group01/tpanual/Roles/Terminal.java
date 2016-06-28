package com.ddsutn.group01.tpanual.Roles;

import java.util.List;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;

public class Terminal {
    private int comuna;
    private String nombreDeTerminal;
    
    public Terminal(String nombreDeTerminal, Integer unaComuna) {
        this.comuna = unaComuna;
        this.nombreDeTerminal = nombreDeTerminal; 
    }
    
    public List<PointOfInterest> find(String criteria) {
        return PoiRepository.getInstance().find(criteria);
    }
}
