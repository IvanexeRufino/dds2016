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

import java.util.List;
import java.util.stream.Collectors;

public class BajaDePOIsTest {
    private BajaDePOIs proceso;
    private DataSourceBajaDePOIsMock dataSource;
    private PoiRepository repo = PoiRepository.getInstance();

    @Before
    public void init() {
        dataSource = new DataSourceBajaDePOIsMock();
        proceso = new BajaDePOIs(dataSource);

        ParadaColectivo paradaUno = new ParadaColectivo(null, null);
        ParadaColectivo paradaDos = new ParadaColectivo(null, null);
        ParadaColectivo paradaTres = new ParadaColectivo(null, null);

        repo.add(paradaUno);
        repo.add(paradaDos);
        repo.add(paradaTres);
    }

    @After
    public void terminate() {
        List<Integer> poiIDs = repo.getOrigenLocal().getAll().stream().map(PointOfInterest::getId)
            .collect(Collectors.toList());

        poiIDs.forEach(PoiRepository.getInstance()::remove);
    }

    @Test
    public void ejecutar() throws Exception {
        int idsToBeDeleted = InterpreterJSON.getListaDePOIs(dataSource.bajaDePOIs()).size();
        int remainingIds = repo.getOrigenLocal().getAll().size() - idsToBeDeleted;

        int deletedIds = proceso.ejecutar();

        Assert.assertEquals(deletedIds, idsToBeDeleted);
        Assert.assertEquals(remainingIds, repo.getOrigenLocal().getAll().size());
    }
}
