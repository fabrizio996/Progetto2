package it.sincrono.crm.contratto.services;

import java.util.List;

import it.sincrono.crm.domain.entities.Contratto;

public interface ContrattoService {
	List<Contratto> findAll();

	Contratto findOne(Integer id);

	void insert(Contratto contratto);

	void update(Contratto contratto);

	void delete(Integer id);
}