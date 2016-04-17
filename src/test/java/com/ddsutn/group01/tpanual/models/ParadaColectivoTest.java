package com.ddsutn.group01.tpanual.models;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Assert;
import org.junit.Test;

import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.models.pois.Usuario;

public class ParadaColectivoTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testParadaColectivoNoEstaCerca() {
		ParadaColectivo unaParada = new ParadaColectivo ("hola","hola",new Point2D.Double(2,3));
		Usuario unUsuario = new Usuario (new Point2D.Double(100,200));
		Assert.assertEquals(false, unUsuario.estaCercaDe(unaParada));
	}
}
