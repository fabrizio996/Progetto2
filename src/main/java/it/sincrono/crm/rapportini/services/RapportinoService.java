package it.sincrono.crm.rapportini.services;

import java.util.List;

import it.sincrono.crm.domain.entities.Rapportino;

public interface RapportinoService {
	public List<Rapportino> findAll();

	public Rapportino findOne(Integer id);

	Double calcolaStipendio(Integer id, Integer mese);

	void insertOne(Rapportino rapportino);
}
