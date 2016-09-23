package com.ddsutn.group01.tpanual.procesos;

import com.ddsutn.group01.tpanual.InterpreterJSON.InterpreterJSON;
import com.ddsutn.group01.tpanual.Procesos.BajaDePOIs;
import com.ddsutn.group01.tpanual.models.mocks.DataSourceBajaDePOIsMock;
import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import org.junit.Assert;
import org.junit.Test;
import org.uqbar.geodds.Point;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class BajaDePOIsTest extends AbstractPersistenceTest implements WithGlobalEntityManager{
    private BajaDePOIs proceso;
    private DataSourceBajaDePOIsMock dataSource;
    private PoiRepository repo = PoiRepository.getInstance();

    @Test
    public void ejecutar() throws Exception {

    	Point p = new Point(4,5);
        ParadaColectivo paradaUno = new ParadaColectivo("114", p);
        ParadaColectivo paradaDos = new ParadaColectivo("115", p);
        ParadaColectivo paradaTres = new ParadaColectivo("116", p);

        repo.add(paradaUno);
        repo.add(paradaDos);
        repo.add(paradaTres);

        dataSource = new DataSourceBajaDePOIsMock(paradaUno.getId(),paradaDos.getId());
        proceso = new BajaDePOIs(dataSource);

        int idsToBeDeleted = InterpreterJSON.getListaDePOIs(dataSource.bajaDePOIs()).size();
        int remainingIds = repo.getOrigenLocal().getAll().size() - idsToBeDeleted;

        int deletedIds = proceso.ejecutar();

        Assert.assertEquals(deletedIds, idsToBeDeleted);
        Assert.assertEquals(remainingIds, repo.getOrigenLocal().getAll().size());
    }
}
