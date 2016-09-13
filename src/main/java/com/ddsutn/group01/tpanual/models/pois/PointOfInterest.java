package com.ddsutn.group01.tpanual.models.pois;

import org.joda.time.DateTime;
import org.uqbar.geodds.Point;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PointOfInterest {
    @Id
    @GeneratedValue
    @Column(name="poi_id")
	private Integer id;
    protected String name;
    protected Point point;
    
    @OneToMany
    @JoinColumn(name="poi_id")
    protected List<String> palabrasClaves;

    public PointOfInterest(Integer id, String name, Point point) {
        this.id = id;
        this.name = name;
        this.point = point;
        palabrasClaves = new ArrayList<>();
    }
    
    public Point getPoint() {
        return point;
    }

    public Integer getId() {
        return id;
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

	public void actualizarPalabrasClaves(String pclaves) {		
	}
}
