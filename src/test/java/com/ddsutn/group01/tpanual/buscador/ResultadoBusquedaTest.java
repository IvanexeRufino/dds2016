package com.ddsutn.group01.tpanual.buscador;

import com.ddsutn.group01.tpanual.actions.Action;
import com.ddsutn.group01.tpanual.actions.ActionWithSearchMetrics;
import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.roles.Terminal;
import com.ddsutn.group01.tpanual.tools.metrics.SearchMetrics;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import java.util.ArrayList;
import java.util.List;

public class ResultadoBusquedaTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    private Terminal terminal;

    @Before
    public void setUp() {
        Buscador buscador = new Buscador();
        terminal = new Terminal("abasto", 1, buscador);
    }

    @Test
    public void busquedaTestGuardaResultadosDeLaBusqueda() throws InterruptedException {
        Point point = new Point(4, 5);
        ParadaColectivo parada = new ParadaColectivo("114", point);
        PoiRepository.getInstance().add(parada);
        terminal.find("114");
        ResultadoBusqueda resultadoBusqueda = (ResultadoBusqueda) entityManager().createQuery("from ResultadoBusqueda").getSingleResult();

        Assert.assertEquals(resultadoBusqueda.getSearchText(), "114");
    }

    @Test
    public void busquedaMasMetricsParaIntegrar() {
        Point point = new Point(4, 5);
        ParadaColectivo parada = new ParadaColectivo("116", point);
        PoiRepository.getInstance().add(parada);
        ActionWithSearchMetrics metrica = new ActionWithSearchMetrics();
        List<Action> acciones = new ArrayList<>();
        acciones.add(metrica);
        terminal.setActions(acciones);
        terminal.find("116");
        ResultadoBusqueda resultadoBusqueda = (ResultadoBusqueda) entityManager().createQuery("from ResultadoBusqueda").getSingleResult();
        SearchMetrics persistedMetricSource = (SearchMetrics) entityManager().createQuery("from SearchMetrics").getSingleResult();

        Assert.assertEquals(resultadoBusqueda.getSearchText(), "116");
        Assert.assertEquals(persistedMetricSource.getResultados(), 1);
    }
}
