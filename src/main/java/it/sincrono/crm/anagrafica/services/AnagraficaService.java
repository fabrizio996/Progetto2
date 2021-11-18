package it.sincrono.crm.anagrafica.services;

import java.util.List;

import it.sincrono.crm.domain.entities.Anagrafica;

public interface AnagraficaService {
	List<Anagrafica> getAll();

	Anagrafica getOne(Integer id) throws Exception;

	void insertOne(Anagrafica anagrafica);

	void updateOne(Anagrafica anagrafica);

	void deleteOne(Integer id) throws Exception;
}
