package com.ddsutn.group01.tpanual.procesos;

import com.ddsutn.group01.tpanual.InterpreterJSON.InterpreterJSON;
import com.ddsutn.group01.tpanual.Procesos.BajaDePOIs;
import com.ddsutn.group01.tpanual.models.mocks.DataSourceBajaDePOIsMock;
import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BajaDePOIsTest {
    private BajaDePOIs proceso;
    private DataSourceBajaDePOIsMock dataSource;
    private PoiRepository repo = PoiRepository.getInstance();
    private EntityManager em = PerThreadEntityManagers.getEntityManager();
    private EntityTransaction tx;

    @Before
    public void init() {
        dataSource = new DataSourceBajaDePOIsMock();
        proceso = new BajaDePOIs(dataSource);
        tx = em.getTransaction();
    }

    @Test
    public void ejecutar() throws Exception {
    	tx.begin();
    	
    	Point p = new Point(4,5);
        ParadaColectivo paradaUno = new ParadaColectivo("114", p);
        ParadaColectivo paradaDos = new ParadaColectivo("115", p);
        ParadaColectivo paradaTres = new ParadaColectivo("116", p);
    	
        repo.add(paradaUno);
        repo.add(paradaDos);
        repo.add(paradaTres);
        
        int idsToBeDeleted = InterpreterJSON.getListaDePOIs(dataSource.bajaDePOIs()).size();
        int remainingIds = repo.getOrigenLocal().getAll().size() - idsToBeDeleted;

        int deletedIds = proceso.ejecutar();

        Assert.assertEquals(deletedIds, idsToBeDeleted);
        Assert.assertEquals(remainingIds, repo.getOrigenLocal().getAll().size());
        tx.rollback();
    }
}
