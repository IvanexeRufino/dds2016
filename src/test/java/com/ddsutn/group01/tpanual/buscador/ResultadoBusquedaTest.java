package com.ddsutn.group01.tpanual.buscador;

import com.ddsutn.group01.tpanual.actions.Action;
import com.ddsutn.group01.tpanual.actions.ActionWithSearchMetrics;
import com.ddsutn.group01.tpanual.db.BigDecimalConverter;
import com.ddsutn.group01.tpanual.db.JodaDateTimeConverter;
import com.ddsutn.group01.tpanual.db.JodaLocalTimeConverter;
import com.ddsutn.group01.tpanual.db.Polygon;
import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.roles.Terminal;
import com.ddsutn.group01.tpanual.tools.metrics.SearchMetrics;
import com.mongodb.MongoClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import java.util.ArrayList;
import java.util.List;

public class ResultadoBusquedaTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    HorariosDeAtencion horarios;
    private Datastore datastore;
    private Terminal terminal;

    @Before
    public void setUp() {
        Buscador buscador = new Buscador();
        terminal = new Terminal("abasto", 1, buscador);

        final Morphia morphia = new Morphia();
        morphia.getMapper().getConverters().addConverter(BigDecimalConverter.class);
        morphia.getMapper().getConverters().addConverter(JodaDateTimeConverter.class);
        morphia.getMapper().getConverters().addConverter(JodaLocalTimeConverter.class);
        morphia.mapPackage("com.ddsutn.group01.tpanual.buscador");
        morphia.mapPackage("com.ddsutn.group01.tpanual.models.pois");
        datastore = morphia.createDatastore(new MongoClient(), "pois");
        datastore.ensureIndexes();
    }

    @After
    public void terminate() {
        datastore.delete(datastore.createQuery(ResultadoBusqueda.class));
    }

    @Test
    public void busquedaTestGuardaResultadosDeLaBusqueda() throws InterruptedException {
        Point point = new Point(4, 5);
        ParadaColectivo parada = new ParadaColectivo("114", point);
        PoiRepository.getInstance().add(parada);
        terminal.find("114");

        ResultadoBusqueda resultadoBusqueda = datastore.find(ResultadoBusqueda.class).get();

        Assert.assertEquals(resultadoBusqueda.getSearchText(), "114");
    }

    @Test
    public void busquedaTestGuardaResultadosDeLaBusquedaLocal() throws InterruptedException {
        Point point = new Point(4, 5);
        Rubro rubro = Rubro.kiosco;

        LocalComercial local = new LocalComercial("elkioskito", point, rubro, horarios);
        local.agregarPalabraClave("comida");

        PoiRepository.getInstance().add(local);
        terminal.find("comida");

        ResultadoBusqueda resultadoBusqueda = datastore.find(ResultadoBusqueda.class).get();

        Assert.assertEquals(resultadoBusqueda.getSearchText(), "comida");
    }

    @Test
    public void busquedaTestGuardaResultadosDeLaBusquedaCGP() throws InterruptedException {
        List<Point> lista = new ArrayList<>();
        Point point = new Point(4, 5);
        lista.add(point);

        Polygon poli = new Polygon(lista);
        CentrosDeGestionYParticipacion cgp = new CentrosDeGestionYParticipacion("cgp", poli);

        PoiRepository.getInstance().add(cgp);
        terminal.find("cgp");

        ResultadoBusqueda resultadoBusqueda = datastore.find(ResultadoBusqueda.class).get();

        Assert.assertEquals(resultadoBusqueda.getSearchText(), "cgp");
    }

    @Test
    public void busquedaTestGuardaResultadosDeLaBusquedaBanco() throws InterruptedException {
        Point point = new Point(4, 5);
        SucursalBanco banco = new SucursalBanco("santander", point);
        banco.agregarPalabraClave("atm");

        PoiRepository.getInstance().add(banco);
        terminal.find("atm");

        ResultadoBusqueda resultadoBusqueda = datastore.find(ResultadoBusqueda.class).get();

        Assert.assertEquals("atm", resultadoBusqueda.getSearchText());
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

        ResultadoBusqueda resultadoBusqueda = datastore.find(ResultadoBusqueda.class).get();
        SearchMetrics persistedMetricSource = (SearchMetrics) entityManager().createQuery("from SearchMetrics").getSingleResult();

        Assert.assertEquals(resultadoBusqueda.getSearchText(), "116");
        Assert.assertEquals(persistedMetricSource.getResultados(), 1);
    }
}
