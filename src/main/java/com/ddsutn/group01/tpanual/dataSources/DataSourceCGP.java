package com.ddsutn.group01.tpanual.dataSources;

import com.ddsutn.group01.tpanual.adapters.CGP.CentroDTO;

import java.util.ArrayList;

public interface DataSourceCGP {
    ArrayList<CentroDTO> search(String criteria);
}
