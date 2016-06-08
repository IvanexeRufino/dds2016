package com.ddsutn.group01.tpanual.repositories.WithActions;

import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.repositories.Repository;
import com.ddsutn.group01.tpanual.tools.Reporter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class RepositoryWithReportTest {
    private RepositoryWithReport repositoryWithReport;
    private Reporter mockedReporter;

    @Before
    public void setUp() throws Exception {
        Repository poiRepo = PoiRepository.getInstance();
        repositoryWithReport = new RepositoryWithReport(poiRepo);
        mockedReporter = Mockito.spy(new Reporter() {
            @Override
            public void updateReport() {}
        });
        repositoryWithReport.setReporter(mockedReporter);
    }

    @Test
    public void find() throws Exception {
        repositoryWithReport.find("foo");
        verify(mockedReporter).updateReport();
    }
}
