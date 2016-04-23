package com.ddsutn.group01.tpanual.models.pois;

import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

public class ParadaColectivo extends PointOfInterest {
    public ParadaColectivo(String name, Point point) {
        super(name, point);
    }

    @Override
    public Boolean estaDisponible(DateTime unHorario) {
    	return true;
    }

    public Boolean palabraEsta(String unaPalabra) {
    	return name.contains(unaPalabra) || super.palabraEsta(unaPalabra);
    }

    @Override
    protected Double criterioDeCercania() {
        return 0.1;
    }
}
