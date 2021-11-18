package it.sincrono.crm.tipologiche.services;

import java.util.List;

import it.sincrono.crm.domain.entities.Provincia;

public interface ProvinciaService {
	List<Provincia> getAll();

	Provincia getOne(Integer id);

	void insertOne(Provincia provincia);

	void updateOne(Provincia provincia);

	void deleteOne(Integer id);
}
