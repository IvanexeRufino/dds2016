package com.ddsutn.group01.tpanual.procesos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ddsutn.group01.tpanual.Procesos.ConfigurarTerminales;
import com.ddsutn.group01.tpanual.Procesos.Filtradores.PorComuna;
import com.ddsutn.group01.tpanual.Roles.Terminal;
import com.ddsutn.group01.tpanual.repositories.Buscador;
import com.ddsutn.group01.tpanual.repositories.actions.Action;


public class ConfigurarTerminalesTest {
    
    private Action mockedAction;
    private Terminal ezeiza;
    private Terminal pacheco;
    private ConfigurarTerminales proceso;
    List<Terminal> terminales = new ArrayList<Terminal>();
    List<Action> acciones = new ArrayList<Action>();
    Buscador buscador = new Buscador();
    PorComuna filtrador = new PorComuna(1);
    
    @Before
    public void init() {
        
        pacheco = new Terminal("pacheco",2,buscador);
        ezeiza = new Terminal("ezeiza",1,buscador);
        mockedAction = Mockito.spy(new Action() {
            @Override
            public void precondition() {}

            @Override
            public void postcondition(String criteria, int result, String terminal) {}
        });
        acciones.add(mockedAction);
        terminales.add(ezeiza);
        terminales.add(pacheco);
        proceso = new ConfigurarTerminales(filtrador,terminales);
        proceso.setAcciones(acciones);
        
    }
    
    @Test
    public void terminalEzeizaTieneUnaAccionConfigurada() throws Exception{
        proceso.ejecutar();
        Assert.assertEquals(1, ezeiza.getAcciones().size());
    }
    
    @Test
    public void terminalPachecoNoTieneAccionesPorqueNoEsDeLaComunaUno() throws Exception{
        proceso.ejecutar();
        Assert.assertEquals(0, pacheco.getAcciones().size());
    }
}
