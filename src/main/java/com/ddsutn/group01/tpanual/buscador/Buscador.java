package com.ddsutn.group01.tpanual.buscador;

import com.ddsutn.group01.tpanual.db.BigDecimalConverter;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;

public class Buscador {

    public List<PointOfInterest> find(String searchText) {
        List<PointOfInterest> results = PoiRepository.getInstance().findAll(searchText);

        final Morphia morphia = new Morphia();
        morphia.getMapper().getOptions().setMapSubPackages(true);
        morphia.getMapper().getConverters().addConverter(BigDecimalConverter.class);
        morphia.mapPackage("com.ddsutn.group01.tpanual.buscador");
        morphia.mapPackage("com.ddsutn.group01.tpanual.models.pois");
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "pois");
        datastore.ensureIndexes();

        datastore.save(new ResultadoBusqueda(searchText, results));

        return results;
    }

}
