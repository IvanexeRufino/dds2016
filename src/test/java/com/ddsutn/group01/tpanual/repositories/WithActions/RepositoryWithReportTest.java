package com.ddsutn.group01.tpanual.repositories.WithActions;

import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.repositories.Repository;
import com.ddsutn.group01.tpanual.tools.Reporter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.HashMap;

public class RepositoryWithReportTest {
    private RepositoryWithReport repositoryWithReport;
    private Reporter mockedReporter;

    @Before
    public void setUp() throws Exception {
        Repository poiRepo = PoiRepository.getInstance();
        repositoryWithReport = new RepositoryWithReport(poiRepo);
        mockedReporter = Mockito.spy(new Reporter() {
            @Override
            public void updateReport(String key, Integer value, HashMap<String, Integer> data) {}
        });
        repositoryWithReport.setReporter(mockedReporter);
    }

    @Test
    public void find() throws Exception {
        HashMap<String, Integer> data = new HashMap<String, Integer>();
        String fecha = LocalDate.now().toString();
        repositoryWithReport.find("foo");
        verify(mockedReporter).updateReport(fecha, 1, data);
    }
}
