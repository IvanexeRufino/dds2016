package com.ddsutn.group01.tpanual.models;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Assert;
import org.junit.Test;

import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.models.pois.Usuario;

public class LocalComercialTest {

	@Test
	public void testLocalComercialNoEstaCerca() {
		LocalComercial unLocal = new LocalComercial ("hola","hola",3,new Point2D.Double(2,3));
		Usuario unUsuario = new Usuario (new Point2D.Double(100,200));
		Assert.assertEquals(false, unUsuario.estaCercaDe(unLocal));
	}

}
