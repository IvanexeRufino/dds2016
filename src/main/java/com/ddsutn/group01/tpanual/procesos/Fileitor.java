package com.ddsutn.group01.tpanual.procesos;

import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Fileitor {
    private String archivo;

    public Fileitor(String archivo) {
        this.archivo = archivo;
    }

    public List<String> disarm() {
        StringTokenizer tok = new StringTokenizer(archivo, "\n");
        int nrotokens = tok.countTokens();
        String[] splitArr = new String[nrotokens];
        for (int i = 0; i < nrotokens; i++) {
            splitArr[i] = tok.nextToken();
        }

        return new ArrayList<>(Arrays.asList(splitArr));
    }

    public void ejecutar() {
        List<String> lalista = this.disarm();

        lalista.forEach(this::basicDisarm);
    }

    public void basicDisarm(String unalinea) {
        String[] aline = unalinea.split(";");
        String nlocal = aline[0];
        String pclaves = aline[1];

        PointOfInterest poiBuscado = PoiRepository.getInstance()
            .getAllLocal().stream()
            .filter(poi -> poi.getName().equals(nlocal))
            .findFirst().get();

        poiBuscado.actualizarPalabrasClaves(pclaves);
    }
}
