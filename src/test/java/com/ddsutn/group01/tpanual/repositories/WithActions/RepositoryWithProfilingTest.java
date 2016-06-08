package com.ddsutn.group01.tpanual.repositories.WithActions;

import com.ddsutn.group01.tpanual.observers.Observer;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.ddsutn.group01.tpanual.repositories.Repository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class RepositoryWithProfilingTest {
    private RepositoryWithProfiling repoProfiling;
    private Observer mockedObserver;

    @Before
    public void setUp() throws Exception {
        mockedObserver = Mockito.spy(new Observer() {
            @Override
            public void inform() {}
        });

        Repository poiRepo = PoiRepository.getInstance();

        repoProfiling = new RepositoryWithProfiling(poiRepo);
        repoProfiling.addObserver(mockedObserver);
    }

    @Test
    public void find() throws Exception {
        int longTime = 10;
        repoProfiling.setSecondsBeforeNotify(longTime);
        repoProfiling.find("foo");
        verify(mockedObserver, never()).inform();
    }

    @Test
    public void findAndNotify() throws Exception {
        repoProfiling.setSecondsBeforeNotify(0);
        repoProfiling.find("foo");
        verify(mockedObserver).inform();
    }
}
