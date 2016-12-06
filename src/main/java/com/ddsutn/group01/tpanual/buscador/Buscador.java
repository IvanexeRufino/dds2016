package com.ddsutn.group01.tpanual.buscador;

import com.ddsutn.group01.tpanual.db.BigDecimalConverter;
import com.ddsutn.group01.tpanual.db.JodaDateTimeConverter;
import com.ddsutn.group01.tpanual.db.JodaLocalTimeConverter;
import com.ddsutn.group01.tpanual.models.pois.PointOfInterest;
import com.ddsutn.group01.tpanual.repositories.PoiRepository;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;

public class Buscador {
	
	private String terminalUsername;
	
	public Buscador(String username) {
		this.terminalUsername = username;
	}

    public List<PointOfInterest> find(String searchText) {
        List<PointOfInterest> results = PoiRepository.getInstance().findAll(searchText);

        final Morphia morphia = new Morphia();
        morphia.getMapper().getConverters().addConverter(BigDecimalConverter.class);
        morphia.getMapper().getConverters().addConverter(JodaDateTimeConverter.class);
        morphia.getMapper().getConverters().addConverter(JodaLocalTimeConverter.class);
        morphia.mapPackage("com.ddsutn.group01.tpanual.buscador");
        morphia.mapPackage("com.ddsutn.group01.tpanual.models.pois");
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "pois");
        datastore.ensureIndexes();

        datastore.save(new ResultadoBusqueda(searchText, results, terminalUsername));

        return results;
    }

}
