package com.ddsutn.group01.tpanual.models.origenes;

import com.ddsutn.group01.tpanual.models.mocks.DataSourceBancosMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class OrigenExternoBancosTest {

    private OrigenExternoBancos origenExternoBancos;

    @Before
    public void setUp() throws Exception {
        origenExternoBancos = new OrigenExternoBancos();
        DataSourceBancosMock dataSourceBancosMock = new DataSourceBancosMock();
        origenExternoBancos.setDataSource(dataSourceBancosMock);
    }

    @Test
    public void buscar() throws Exception {
        Assert.assertFalse(origenExternoBancos.buscar("Banco de la Plaza").isEmpty());
    }

}
