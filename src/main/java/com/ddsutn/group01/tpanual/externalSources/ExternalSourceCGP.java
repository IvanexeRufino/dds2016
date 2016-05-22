package com.ddsutn.group01.tpanual.externalSources;

import com.ddsutn.group01.tpanual.adapters.CGP.CentroDTO;

import java.util.ArrayList;

public interface ExternalSourceCGP {
    ArrayList<CentroDTO> search(String criteria);
}
