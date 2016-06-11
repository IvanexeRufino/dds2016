//package com.ddsutn.group01.tpanual.repositories.actions;
//
//import com.ddsutn.group01.tpanual.tools.observers.Observer;
//import com.ddsutn.group01.tpanual.repositories.PoiRepository;
//import com.ddsutn.group01.tpanual.repositories.Repository;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.verify;
//
//public class ProfilingTest {
//    private Profiling repoProfiling;
//    private Observer mockedObserver;
//
//    @Before
//    public void setUp() throws Exception {
//        mockedObserver = Mockito.spy(new Observer() {
//            @Override
//            public void inform() {}
//        });
//
//        Repository poiRepo = PoiRepository.getInstance();
//
//        repoProfiling = new Profiling(poiRepo);
//        repoProfiling.addObserver(mockedObserver);
//    }
//
//    @Test
//    public void find() throws Exception {
//        int longTime = 10;
//        repoProfiling.setSecondsBeforeNotify(longTime);
//        repoProfiling.find("foo");
//        verify(mockedObserver, never()).inform();
//    }
//
//    @Test
//    public void findAndNotify() throws Exception {
//        repoProfiling.setSecondsBeforeNotify(0);
//        repoProfiling.find("foo");
//        verify(mockedObserver).inform();
//    }
//}
