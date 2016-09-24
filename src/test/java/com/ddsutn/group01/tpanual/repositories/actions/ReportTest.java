//package com.ddsutn.group01.tpanual.repositories.actions;
//
//import com.ddsutn.group01.tpanual.repositories.PoiRepository;
//import com.ddsutn.group01.tpanual.repositories.Repository;
//import com.ddsutn.group01.tpanual.tools.reporters.Reporter;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import static org.mockito.Mockito.verify;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//
//public class ReportTest {
//    private ActionWithReport report;
//    private Reporter mockedReporter;
//
//    @Before
//    public void setUp() throws Exception {
//        Repository poiRepo = PoiRepository.getInstance();
//        report = new ActionWithReport(poiRepo);
//        mockedReporter = Mockito.spy(new Reporter() {
//            @Override
//            public void updateReport(String key, Integer value, HashMap<String, Integer> data) {}
//        });
//        report.setReporter(mockedReporter);
//    }
//
//    @Test
//    public void find() throws Exception {
//        HashMap<String, Integer> data = new HashMap<String, Integer>();
//        String fecha = LocalDate.now().toString();
//        report.find("foo");
//        verify(mockedReporter).updateReport(fecha, 1, data);
//    }
//}
