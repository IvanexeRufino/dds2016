package com.ddsutn.group01.tpanual.models;

import org.junit.Assert;
import org.junit.Test;

public class RubroTest {
    private Rubro rubro;

    @Test
    public void kiscoRadioDeCercania() {
        rubro = Rubro.kiosco;
        Assert.assertEquals(0.2, rubro.getRadioDeCercania(), 0);
    }
    @Test
    public void rubroLibreriaEstaCercaDe() {
        rubro = Rubro.libreriaEscolar;
        Assert.assertEquals(0.5, rubro.getRadioDeCercania(), 0);
    }

    @Test
    public void rubroMuebleriaEstaCercaDe() {
        rubro = Rubro.muebleria;
        Assert.assertEquals(0.4, rubro.getRadioDeCercania(), 0);
    }
}
