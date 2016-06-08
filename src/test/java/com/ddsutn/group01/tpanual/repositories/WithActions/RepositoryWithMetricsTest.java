package com.ddsutn.group01.tpanual.repositories.WithActions;

import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.repositories.Repository;
import com.ddsutn.group01.tpanual.tools.metrics.Metrics;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class RepositoryWithMetricsTest {
    private RepositoryWithMetrics repoWithMetrics;
    private Metrics mockedMetrics;

    @Before
    public void setUp() throws Exception {
        Repository poiRepo = PoiRepository.getInstance();
        repoWithMetrics = new RepositoryWithMetrics(poiRepo);
        mockedMetrics = Mockito.spy(new Metrics() {
            @Override
            public void reportStat(String criteria, int resultsCount, long timeLapsed) {}
        });
        repoWithMetrics.setMetricsSource(mockedMetrics);
    }

    @Test
    public void find() throws Exception {
        repoWithMetrics.find("foo");
        verify(mockedMetrics).reportStat(any(String.class), any(int.class), any(long.class));
    }
}
