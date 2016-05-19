package com.ddsutn.group01.tpanual.models.CgpDTO;

import java.util.ArrayList;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;

public class CgpAdapter {
    public ArrayList<PointOfInterest> parsear(ArrayList<CentroDTO> listaCentroDTO) {
        ArrayList<PointOfInterest> listaCgp = new ArrayList<>();
        listaCentroDTO.forEach(centro->listaCgp.add(centro.modelar()));
        return listaCgp;
    }
}
