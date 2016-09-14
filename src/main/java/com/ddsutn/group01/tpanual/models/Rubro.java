package com.ddsutn.group01.tpanual.models;

import javax.persistence.Entity;

@Entity
public enum Rubro {
    libreriaEscolar(0.5), kiosco(0.2), muebleria(0.4);

    private double radioDeCercania;

    Rubro(double unRadio) {
        this.radioDeCercania = unRadio;
    }

    public double getRadioDeCercania() {
        return radioDeCercania;
    }

    public String getNombre() {
        return name();
    }
}
