package com.ddsutn.group01.tpanual;

import com.ddsutn.group01.tpanual.db.Polygon;
import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.DayOfWeek;
import java.util.Arrays;

public class PersistentRecordTest {
    private EntityManager entityManager;

    @Before
    public void setUp() {
        entityManager = PerThreadEntityManagers.getEntityManager();
    }

    @Test
    public void xxx() {
        HorariosDeAtencion horariosDeAtencion = new HorariosDeAtencion();
        horariosDeAtencion.agregarHorario(new Horario(DayOfWeek.THURSDAY, new LocalTime(10, 0), new LocalTime(19, 0)));
        horariosDeAtencion.agregarHorario(new Horario(DayOfWeek.FRIDAY, new LocalTime(9, 0), new LocalTime(18, 0)));

        LocalComercial localComercial = new LocalComercial("foo", new Point(1, 2), Rubro.kiosco, horariosDeAtencion);
        localComercial.agregarPalabraClave("foo");
        localComercial.agregarPalabraClave("bleh");
        localComercial.agregarPalabraClave("sarasa");

        Polygon polygon = new Polygon(Arrays.asList(new Point(1, 2), new Point(3, 4)));
        Servicio servicio = new Servicio("servicio", horariosDeAtencion);
        CentrosDeGestionYParticipacion cgp = new CentrosDeGestionYParticipacion("foo", polygon);
        cgp.agregarUnServicio(servicio);

        SucursalBanco sucursalBanco = new SucursalBanco("banco", new Point(5, 6));
        sucursalBanco.agregarUnServicio(servicio);
        sucursalBanco.agregarPalabraClave("many");

        EntityTransaction tx = entityManager.getTransaction();

        tx.begin();
        entityManager.persist(localComercial);
        entityManager.persist(cgp);
        entityManager.persist(sucursalBanco);
        tx.commit();

        LocalComercial persistedLocalComercial = entityManager.find(LocalComercial.class, localComercial.getId());

        Assert.assertEquals(persistedLocalComercial.getId(), localComercial.getId());
        Assert.assertEquals(persistedLocalComercial.getPoint().latitude(), 1.0, 0);
        Assert.assertEquals(persistedLocalComercial.getPoint().longitude(), 2.0, 0);
        Assert.assertEquals(persistedLocalComercial.getRubro(), Rubro.kiosco);
        Assert.assertEquals(persistedLocalComercial.getPalabrasClaves(), Arrays.asList("foo", "bleh", "sarasa"));
        Assert.assertEquals(persistedLocalComercial.getHorarioDeAtencion().getHorarios(), horariosDeAtencion.getHorarios());

//        System.out.println(entityManager.createQuery("from PointOfInterest").getResultList());
    }
}
