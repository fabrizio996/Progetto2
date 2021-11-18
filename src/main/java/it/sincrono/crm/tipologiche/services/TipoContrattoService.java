package it.sincrono.crm.tipologiche.services;

import java.util.List;

import it.sincrono.crm.domain.entities.TipoContratto;

public interface TipoContrattoService {
	List<TipoContratto> getAll();

	TipoContratto getOne(Integer id);

	void insertOne(TipoContratto tipoContratto);

	void updateOne(TipoContratto tipoContratto);

	void deleteOne(Integer id);
}
