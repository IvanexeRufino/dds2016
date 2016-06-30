package com.ddsutn.group01.tpanual.procesos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ddsutn.group01.tpanual.Procesos.BajaDePOIs;
import com.ddsutn.group01.tpanual.models.mocks.DataSourceBajaDePOIsMock;
import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;

public class BajaDePOIsTest {
    private BajaDePOIs proceso;
    private PoiRepository repo = PoiRepository.getInstance();
    
    @Before
    public void init() {
        DataSourceBajaDePOIsMock dataSource = new DataSourceBajaDePOIsMock();
        proceso = new BajaDePOIs(dataSource);
        ParadaColectivo siete = new ParadaColectivo(1,null,null);
        ParadaColectivo ocho = new ParadaColectivo(2,null,null);
        ParadaColectivo nueve = new ParadaColectivo(3,null,null);
        ParadaColectivo diez = new ParadaColectivo(4,null,null);
        ParadaColectivo once = new ParadaColectivo(5,null,null);
        ParadaColectivo doce = new ParadaColectivo(6,null,null);
        repo.add(siete);
        repo.add(ocho);
        repo.add(nueve);
        repo.add(diez);
        repo.add(once);
        repo.add(doce);
    }
    
    @Test
    public void bajaDePOIEliminaCincoPois() throws Exception{
        int resultados = proceso.ejecutar();
        Assert.assertEquals(resultados,5);
    }
    
    @Test
    public void BajaDePOINoEliminaADoce() throws Exception{
        proceso.ejecutar();
        Assert.assertEquals(2, repo.getOrigenLocal().getAll().size());
    }
    
}
