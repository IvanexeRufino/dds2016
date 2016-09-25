package com.ddsutn.group01.tpanual.procesos.filters;

import com.ddsutn.group01.tpanual.roles.Terminal;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class TerminalesDeterminadasFilterTest {

    @Test
    public void filtrar() throws Exception {
        List<Terminal> selectedTerminals = new ArrayList<>();
        selectedTerminals.add(Mockito.mock(Terminal.class));
        selectedTerminals.add(Mockito.mock(Terminal.class));

        TerminalesDeterminadasFilter terminalesDeterminadasFilter = new TerminalesDeterminadasFilter(selectedTerminals);

        List<Terminal> allTerminals = new ArrayList<>();
        allTerminals.addAll(selectedTerminals);
        allTerminals.add(Mockito.mock(Terminal.class));
        allTerminals.add(Mockito.mock(Terminal.class));

        Assert.assertEquals(terminalesDeterminadasFilter.filtrar(allTerminals), selectedTerminals);
    }

}
