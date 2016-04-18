package com.ddsutn.group01.tpanual.models;

public enum Rubro {
    libreriasEscolares(0.5), kiosco(0.2);

    private double radioDeCercania;

    Rubro(double radioDeCercania) {
        this.radioDeCercania = radioDeCercania;
    }

    public double getRadioDeCercania() {
        return radioDeCercania;
    }
}
