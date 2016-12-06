package com.ddsutn.group01.tpanual.procesos;

import com.ddsutn.group01.tpanual.procesos.filters.ComunaFilter;
import com.ddsutn.group01.tpanual.buscador.Buscador;
import com.ddsutn.group01.tpanual.actions.Action;
import com.ddsutn.group01.tpanual.roles.ConfigurarTerminales;
import com.ddsutn.group01.tpanual.roles.Terminal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


public class ConfigurarTerminalesTest {

    private Terminal ezeiza;
    private Terminal pacheco;
    private ConfigurarTerminales proceso;

    @Before
    public void init() {
        List<Terminal> terminales = new ArrayList<>();
        List<Action> acciones = new ArrayList<>();
        Buscador buscador = new Buscador("terminal");
        ComunaFilter filtrador = new ComunaFilter(1);

        pacheco = new Terminal("pacheco", 2, buscador);
        ezeiza = new Terminal("ezeiza", 1, buscador);
        Action mockedAction = Mockito.mock(Action.class);

        acciones.add(mockedAction);
        terminales.add(ezeiza);
        terminales.add(pacheco);
        proceso = new ConfigurarTerminales(filtrador, terminales);
        proceso.setAcciones(acciones);
    }

    @Test
    public void terminalEzeizaTieneUnaAccionConfigurada() throws Exception {
        proceso.ejecutar();

        Assert.assertEquals(1, ezeiza.getAcciones().size());
    }

    @Test
    public void terminalPachecoNoTieneAccionesPorqueNoEsDeLaComunaUno() throws Exception {
        proceso.ejecutar();

        Assert.assertEquals(0, pacheco.getAcciones().size());
    }
}
