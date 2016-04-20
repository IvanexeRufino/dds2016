package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

public class LocalComercialTest {
    private Point point;
    private HorariosDeAtencion horarioDeAtencion;
    private Rubro kioscoDeDiario;
    private Rubro libreria;
    private LocalComercial elDiariero;
    private LocalComercial libreriaLapiz;

    @Before
    public void init() {
        point = new Point(-34.603689, -58.381652); // https://goo.gl/maps/NquccBrGJsz
        horarioDeAtencion = new HorariosDeAtencion();
        kioscoDeDiario = new Rubro ("kioscoDeDiario",0.2);
        libreria= new Rubro ("libreria",0.5);
        elDiariero = new LocalComercial ("elDiariero", point, kioscoDeDiario, horarioDeAtencion);
        libreriaLapiz = new LocalComercial ("libreriaLapiz",point,libreria,horarioDeAtencion);
    
        
    }

    @Test
    public void rubroKioscoEstaCercaDe() {
        Point anotherPoint = new Point(-34.601921, -58.381701); // https://goo.gl/maps/P9bmo5D2P8r
        Assert.assertTrue(elDiariero.estaCercaDe(anotherPoint));
    }
    
    @Test
    public void rubroKioscoNoEstaCercaDe() {
        Point anotherPoint = new Point(-34.601921, -59.381701);
        Assert.assertFalse(elDiariero.estaCercaDe(anotherPoint));
    }

    @Test
    public void rubroLibreriaEstaCercaDe() {
        Point anotherPoint = new Point(-34.601400, -58.381726); // https://goo.gl/maps/ejnwoTqr7D62
        Assert.assertTrue(libreriaLapiz.estaCercaDe(anotherPoint));
    }
    
    @Test
    public void rubroLibreriaNoEstaCercaDe() {
        Point anotherPoint = new Point(-34.601400, -59.381726);
        Assert.assertFalse(libreriaLapiz.estaCercaDe(anotherPoint));
    }

}
