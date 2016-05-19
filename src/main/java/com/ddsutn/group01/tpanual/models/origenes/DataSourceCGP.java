package com.ddsutn.group01.tpanual.models.origenes;

import java.util.ArrayList;

import com.ddsutn.group01.tpanual.models.CgpDTO.CentroDTO;

public interface DataSourceCGP {
    public ArrayList<CentroDTO> buscar(String criterio);
}
