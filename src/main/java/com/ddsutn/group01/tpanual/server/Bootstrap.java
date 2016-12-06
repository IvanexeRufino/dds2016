package com.ddsutn.group01.tpanual.server;

import com.ddsutn.group01.tpanual.buscador.Buscador;
import com.ddsutn.group01.tpanual.buscador.ResultadoBusqueda;
import com.ddsutn.group01.tpanual.db.Polygon;
import com.ddsutn.group01.tpanual.models.Horario;
import com.ddsutn.group01.tpanual.models.HorariosDeAtencion;
import com.ddsutn.group01.tpanual.models.Rubro;
import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.CentrosDeGestionYParticipacion;
import com.ddsutn.group01.tpanual.models.pois.LocalComercial;
import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;
import com.ddsutn.group01.tpanual.repositories.UserRepository;
import com.ddsutn.group01.tpanual.roles.Admin;
import com.ddsutn.group01.tpanual.roles.Terminal;
import org.joda.time.LocalTime;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import javax.persistence.EntityManager;
import java.time.DayOfWeek;
import java.util.Arrays;


public class Bootstrap extends AbstractPersistenceTest implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps {

    public void init() {
        withTransaction(() -> {
            EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
            Terminal proyecto = new Terminal("terminalAbasto",5,new Buscador("terminal"));
            proyecto.setUsername("terminal");
            proyecto.setPassword("terminal");
            UserRepository.getInstance().add(proyecto);

            Admin pro = new Admin();
            pro.setUsername("admin");
            pro.setPassword("admin");
            UserRepository.getInstance().add(pro);
            
            HorariosDeAtencion horariosDeAtencion = new HorariosDeAtencion();
            horariosDeAtencion.agregarHorario(new Horario(DayOfWeek.THURSDAY, new LocalTime(10, 0), new LocalTime(19, 0)));
            horariosDeAtencion.agregarHorario(new Horario(DayOfWeek.FRIDAY, new LocalTime(9, 0), new LocalTime(18, 0)));

            LocalComercial localComercial = new LocalComercial("local 1", new Point(1, 2), Rubro.kiosco, horariosDeAtencion);
            localComercial.agregarPalabraClave("comida");
            localComercial.agregarPalabraClave("golosinas");
            localComercial.agregarPalabraClave("cigarrillos");

            LocalComercial localComercial2 = new LocalComercial("local 2", new Point(1, 2), Rubro.libreriaEscolar, horariosDeAtencion);
            localComercial2.agregarPalabraClave("libros");
            localComercial2.agregarPalabraClave("útiles");
            localComercial2.agregarPalabraClave("escuela");

            ParadaColectivo paradaColectivo = new ParadaColectivo("114", new Point(1, 2));
            paradaColectivo.agregarPalabraClave("parada");
            paradaColectivo.agregarPalabraClave("colectivo");

            ParadaColectivo paradaColectivo2 = new ParadaColectivo("7", new Point(1, 2));
            paradaColectivo2.agregarPalabraClave("parada");
            paradaColectivo2.agregarPalabraClave("colectivo");

            Polygon polygon = new Polygon(Arrays.asList(new Point(1, 2), new Point(3, 4)));
            Servicio servicio = new Servicio("servicio", horariosDeAtencion);
            CentrosDeGestionYParticipacion cgp = new CentrosDeGestionYParticipacion("cgp", polygon);
            cgp.agregarUnServicio(servicio);
            cgp.agregarPalabraClave("cgp");

            SucursalBanco sucursalBanco = new SucursalBanco("banco", new Point(5, 6));
            sucursalBanco.agregarUnServicio(servicio);
            sucursalBanco.agregarPalabraClave("efectivo");
            sucursalBanco.agregarPalabraClave("cheques");
            sucursalBanco.agregarPalabraClave("retiro efectivo");

            entityManager.persist(localComercial);
            entityManager.persist(localComercial2);
            entityManager.persist(paradaColectivo);
            entityManager.persist(paradaColectivo2);
            entityManager.persist(cgp);
            entityManager.persist(sucursalBanco);
        });
    }

}
