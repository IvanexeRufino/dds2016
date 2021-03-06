package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.db.PersistentRecord;
import com.ddsutn.group01.tpanual.db.PointConverter;
import com.ddsutn.group01.tpanual.db.StringListConverter;
import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PointOfInterest extends PersistentRecord {
    @Column
    protected String name;

    @Column
    @Convert(converter = PointConverter.class)
    protected Point point;

    @Column
    @Convert(converter = StringListConverter.class)
    protected List<String> palabrasClaves;

    public Double getLatitude() {
    	return point.latitude();
    }
    
    public Double getLongitude() {
    	return point.longitude();
    }
    
    public PointOfInterest() {
    }

    public PointOfInterest(String name, Point point) {
        this.name = name;
        this.point = point;
        palabrasClaves = new ArrayList<>();
    }

    public void setName(String name) {
		this.name = name;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Point getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public List<String> getPalabrasClaves() {
        return palabrasClaves;
    }

    public final void agregarPalabraClave(String unaPalabra) {
        palabrasClaves.add(unaPalabra);
    }

    public final Boolean palabraEsta(String unaPalabra) {
        return palabrasClaves.contains(unaPalabra) || cumpleCondicion(unaPalabra);
    }

    public Boolean estaCercaDe(Point anotherPoint) {
        return point.distance(anotherPoint) < criterioDeCercania();
    }

    public abstract Boolean estaDisponible(DateTime unHorario);

    protected abstract Boolean cumpleCondicion(String unaPalabra);

    protected Double criterioDeCercania() {
        return 0.5;
    }

    // TODO: FIX ME
    public void actualizarPalabrasClaves(String pclaves) {
    }
}
