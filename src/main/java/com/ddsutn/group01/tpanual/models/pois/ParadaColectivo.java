package com.ddsutn.group01.tpanual.models.pois;

import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

public class ParadaColectivo extends PointOfInterest {
    public ParadaColectivo(Integer id, String name, Point point) {
        super(id, name, point);
    }

    @Override
    public Boolean estaDisponible(DateTime unHorario) {
    	return true;
    }
    @Override
    public Boolean cumpleCondicion(String unaPalabra) {
    	return name.contains(unaPalabra);
    }

    @Override
    protected Double criterioDeCercania() {
        return 0.1;
    }
}
