package com.ddsutn.group01.tpanual.models.CgpDTO;

public class DiasDeServicio {
	private int numeroDeDia;
	private int horaDesde;
	private int minutoDesde;
	private int horaHasta;
	private int minutoHasta;

	public int getNumeroDeDia() {
        return numeroDeDia;
    }

    public void setNumeroDeDia(int numeroDeDia) {
        this.numeroDeDia = numeroDeDia;
    }

    public int getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(int horaDesde) {
        this.horaDesde = horaDesde;
    }

    public int getMinutoDesde() {
        return minutoDesde;
    }

    public void setMinutoDesde(int minutoDesde) {
        this.minutoDesde = minutoDesde;
    }

    public int getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(int horaHasta) {
        this.horaHasta = horaHasta;
    }

    public int getMinutoHasta() {
        return minutoHasta;
    }

    public void setMinutoHasta(int minutoHasta) {
        this.minutoHasta = minutoHasta;
    }
}
