package com.ddsutn.group01.tpanual.procesos;

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
    private PoiRepository repo = PoiRepository.getInstance();

    @Before
    public void init() {
        DataSourceBajaDePOIsMock dataSource = new DataSourceBajaDePOIsMock();
        proceso = new BajaDePOIs(dataSource);

        ParadaColectivo paradaUno = new ParadaColectivo(1, null, null);
        ParadaColectivo paradaDos = new ParadaColectivo(2, null, null);
        ParadaColectivo paradaTres = new ParadaColectivo(3, null, null);

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
        int resultados = proceso.ejecutar();
        Assert.assertEquals(resultados, 2);
        Assert.assertEquals(1, repo.getOrigenLocal().getAll().size());
    }
}
