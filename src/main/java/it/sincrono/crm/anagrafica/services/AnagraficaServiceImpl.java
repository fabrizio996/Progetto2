package it.sincrono.crm.anagrafica.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import it.sincrono.crm.anagrafica.repositories.AnagraficaRepository;
import it.sincrono.crm.domain.entities.Anagrafica;

@Service
public class AnagraficaServiceImpl implements AnagraficaService {
	@Autowired
	private AnagraficaRepository repository;

	@Override
	public List<Anagrafica> getAll() {
		return repository.findAll();
	}

	@Override
	public Anagrafica getOne(Integer id) throws Exception {
		Anagrafica anagrafica;

		try {
			Optional<Anagrafica> optional = repository.findById(id);
			anagrafica = optional.get();
		} catch (NoSuchElementException e) {
			throw new Exception("nessuna anagrafica con id " + id);
		}

		return anagrafica;
	}

	@Override
	public void insertOne(Anagrafica anagrafica) {
		repository.save(anagrafica);
	}

	@Override
	public void updateOne(Anagrafica anagrafica) {
		repository.save(anagrafica);
	}

	@Override
	public void deleteOne(Integer id) throws Exception {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception("nessuna anagrafica con id " + id);
		}
	}

}
