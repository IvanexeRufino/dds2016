package com.ddsutn.group01.tpanual.models.CgpDTO;

import java.util.ArrayList;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;

public class CgpAdapter {
	public ArrayList<CentrosDeGestionYParticipacion> adaptar(ArrayList<CentroDTO> listaCentroDTO) {
		ArrayList<CentrosDeGestionYParticipacion> listaCgp = new ArrayList<>();
        listaCentroDTO.forEach(centro->listaCgp.add(centro.modelar()));
        return listaCgp;
    }
}
