package com.ddsutn.group01.tpanual.models.pois;

import com.ddsutn.group01.tpanual.PersistentRecord;
import com.ddsutn.group01.tpanual.db.PointConverter;
import com.ddsutn.group01.tpanual.db.StringListConverter;
import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PointOfInterest extends PersistentRecord {
    @Column
    protected String name;

    @Convert(converter = PointConverter.class)
    protected Point point;

    @Column
    @Convert(converter = StringListConverter.class)
    protected List<String> palabrasClaves;

    public PointOfInterest(String name, Point point) {
        this.name = name;
        this.point = point;
        palabrasClaves = new ArrayList<>();
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
