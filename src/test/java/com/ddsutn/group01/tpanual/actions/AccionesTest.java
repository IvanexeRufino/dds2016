package com.ddsutn.group01.tpanual.actions;

import com.ddsutn.group01.tpanual.buscador.ResultadoBusqueda;
import com.ddsutn.group01.tpanual.db.BigDecimalConverter;
import com.ddsutn.group01.tpanual.db.JodaDateTimeConverter;
import com.ddsutn.group01.tpanual.db.JodaLocalTimeConverter;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.buscador.Buscador;
import com.ddsutn.group01.tpanual.roles.Terminal;
import com.mongodb.MongoClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

public class AccionesTest extends AbstractPersistenceTest implements WithGlobalEntityManager {
    private Action mockedAction;
    private Terminal unaTerminal;
    private Buscador buscador = new Buscador();
    private Datastore datastore;

    @Before
    public void setUp() throws Exception {
        unaTerminal = new Terminal("terminalUrquiza", 1, buscador);
        mockedAction = Mockito.mock(Action.class);

        unaTerminal.addAction(mockedAction);

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
    public void runsPrecondition() throws Exception {
        unaTerminal.find("foo");
        verify(mockedAction).precondition();
    }

    @Test
    public void runsPostcondition() throws Exception {
        unaTerminal.find("foo");
        verify(mockedAction).postcondition(any(String.class), anyListOf(PointOfInterest.class).size(), any(String.class));
    }
}
