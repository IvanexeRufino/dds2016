package com.ddsutn.group01.tpanual.adapters.Banco;

import com.ddsutn.group01.tpanual.models.Servicio;

import java.util.ArrayList;

class BancoDTO {
    private Integer id;
    private String banco;
    private Double x;
    private Double y;
    private String sucursal;
    private String gerente;
    private ArrayList<String> servicios;
    private Servicio servicio;

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
}
