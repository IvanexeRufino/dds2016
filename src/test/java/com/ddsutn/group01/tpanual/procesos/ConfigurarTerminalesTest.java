package com.ddsutn.group01.tpanual.procesos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ddsutn.group01.tpanual.Procesos.ConfigurarTerminales;
import com.ddsutn.group01.tpanual.Roles.Terminal;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.Buscador;
import com.ddsutn.group01.tpanual.repositories.actions.Action;


public class ConfigurarTerminalesTest {
    
    private Action mockedAction;
    private Buscador unBuscador = new Buscador();
    private Terminal ezeiza;
    private Terminal pacheco;
    private ConfigurarTerminales proceso;
    List<Terminal> terminales = new ArrayList<Terminal>();
    List<Action> acciones = new ArrayList<Action>();
    
    @Before
    public void init() {
        pacheco = new Terminal("pacheco",2,unBuscador);
        ezeiza = new Terminal("ezeiza",1,unBuscador);
        mockedAction = Mockito.spy(new Action() {
            @Override
            public void precondition() {}

            @Override
            public void postcondition(String criteria, List<PointOfInterest> result) {}
        });
        acciones.add(mockedAction);
        terminales.add(ezeiza);
        terminales.add(pacheco);
        proceso = new ConfigurarTerminales(terminales);
        proceso.setAcciones(acciones);
        
    }
    
    @Test
    public void terminalEzeizaTieneUnaAccionConfigurada() {
        proceso.ejecutar();
        Assert.assertEquals(1, ezeiza.getAcciones().size());
    }
    
    @Test
    public void terminalPachecoNoTieneAccionesPorqueNoEsDeLaComunaUno() {
        proceso.configurarTerminalesPorComuna(1);
        proceso.ejecutar();
        Assert.assertEquals(0, pacheco.getAcciones().size());
    }
}
