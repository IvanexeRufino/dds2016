package com.ddsutn.group01.tpanual.repositories;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.actions.Action;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

public class BuscadorTest {
    private Action mockedAction;
    PoiRepository poiRepo = PoiRepository.getInstance();

    @Before
    public void setUp() throws Exception {
        mockedAction = Mockito.spy(new Action() {
            @Override
            public void precondition() {}

            @Override
            public void postcondition(String criteria, List<PointOfInterest> result) {}
        });

        poiRepo.addAction(mockedAction);
    }

    @Test
    public void runsPrecondition() throws Exception {
        poiRepo.find("foo");
        verify(mockedAction).precondition();
    }

    @Test
    public void runsPostcondition() throws Exception {
        poiRepo.find("foo");
        verify(mockedAction).postcondition(any(String.class), anyListOf(PointOfInterest.class));
    }
}
