package com.ddsutn.group01.tpanual.models.InterfazBancos;

import java.util.ArrayList;

import org.uqbar.geodds.Point;

import com.ddsutn.group01.tpanual.models.Servicio;
import com.ddsutn.group01.tpanual.models.pois.SucursalBanco;

public class CreadorDeBancos {
    private Integer id;
    private String banco;
    private Double x;
    private Double y;
    private String sucursal;
    private String gerente;
    private ArrayList<String> servicios;
    private Servicio servicio;

    //Creo que el jackson necesita todos los getters y setters, por eso los genere


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public ArrayList<String> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<String> servicios) {
        this.servicios = servicios;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public SucursalBanco modelarBanco() {
        ArrayList<Servicio> serviciosReales = new ArrayList<Servicio>();
        Point punto = new Point(x,y);
        SucursalBanco sucursal = new SucursalBanco(id, banco, punto);
        servicios.stream().forEach(nombre->serviciosReales.add(servicio = new Servicio(nombre,null)));
        sucursal.setServicios(serviciosReales);
        return sucursal;
    }
}
