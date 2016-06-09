package com.ddsutn.group01.tpanual.repositories.WithActions;

import static org.mockito.Mockito.verify;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.repositories.Repository;
import com.ddsutn.group01.tpanual.tools.reporters.Reporter;

public class RepositoryWithTerminalReportTest {
	private RepositoryWithTerminalReport repositoryWithTerminalReport;
	private Reporter mockedReporter;

	@Before
	public void setUp() throws Exception {
	    Repository poiRepo = PoiRepository.getInstance();
	    repositoryWithTerminalReport = new RepositoryWithTerminalReport(poiRepo, "terminalAbasto");
	    mockedReporter = Mockito.spy(new Reporter() {
            @Override
            public void updateReport(String key, Integer value, HashMap<String, Integer> data) {}
        });
        repositoryWithTerminalReport.setReporter(mockedReporter);
    }

    @Test
    public void find() throws Exception {
        HashMap<String, Integer> data = new HashMap<String, Integer>();
        repositoryWithTerminalReport.find("foo");
        verify(mockedReporter).updateReport("foo",repositoryWithTerminalReport.find("foo").size(),data);
    }

}
