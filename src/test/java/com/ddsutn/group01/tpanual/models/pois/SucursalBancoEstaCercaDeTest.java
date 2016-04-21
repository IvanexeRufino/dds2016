package com.ddsutn.group01.tpanual.models.pois;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

public class SucursalBancoEstaCercaDeTest {
    private Point point;
    private SucursalBanco santander;
    private Point anotherPoint;
    private Point anotherAnotherPoint;

    @Before
    public void init() {
    	point = new Point(-34.603689, -58.381652); // https://goo.gl/maps/NquccBrGJsz
    	anotherPoint = new Point(-34.601921, -58.381701); // https://goo.gl/maps/P9bmo5D2P8r
    	anotherAnotherPoint = new Point (-34.6039217, -58.399196);
        santander = new SucursalBanco("santander", point);
    }

    @Test
    public void BancoEstaCercaDe() {
        Assert.assertTrue(santander.estaCercaDe(anotherPoint));
    }

    @Test
    public void BancoNoEstaCercaDe() {
    	 Assert.assertFalse(santander.estaCercaDe(anotherAnotherPoint));
    }
}
