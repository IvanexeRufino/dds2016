package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbar.geodds.Point;

import static org.mockito.Matchers.*;

public class LocalComercialTest {
    private LocalComercial unKiosco;
    private LocalComercial unaLibreriaEscolar;
    private LocalComercial unaMuebleria;
    private Point mockedPoint;

    @Before
    public void init() {
        mockedPoint =  Mockito.mock(Point.class);
        HorariosDeAtencion horarioDeAtencion = Mockito.mock(HorariosDeAtencion.class);
        Rubro kisco = Rubro.kiosco;
        Rubro libreria = Rubro.libreriaEscolar;
        Rubro muebleria = Rubro.muebleria;

        unKiosco = new LocalComercial("kiosco", mockedPoint, kisco, horarioDeAtencion);
        unaLibreriaEscolar = new LocalComercial("libreriaEscolar", mockedPoint, libreria, horarioDeAtencion);
        unaMuebleria = new LocalComercial("muebleria", mockedPoint, muebleria, horarioDeAtencion);

    }

    @Test
    public void rubroKioscoEstaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.19);
        Assert.assertTrue(unKiosco.estaCercaDe(any(Point.class)));
    }

    @Test
    public void rubroKioscoNoEstaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.2);
        Assert.assertFalse(unKiosco.estaCercaDe(any(Point.class)));
    }

    @Test
    public void rubroLibreriaEstaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.49);
        Assert.assertTrue(unaLibreriaEscolar.estaCercaDe(any(Point.class)));
    }

    @Test
    public void rubroLibreriaNoEstaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.5);
        Assert.assertFalse(unaLibreriaEscolar.estaCercaDe(any(Point.class)));
    }

    @Test
    public void rubroMuebleriaEstaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.39);
        Assert.assertTrue(unaMuebleria.estaCercaDe(any(Point.class)));
    }

    @Test
    public void rubroMuebleriaNoEstaCercaDe() {
        Mockito.when(mockedPoint.distance(any(Point.class))).thenReturn(0.4);
        Assert.assertFalse(unaMuebleria.estaCercaDe(any(Point.class)));
    }

}
