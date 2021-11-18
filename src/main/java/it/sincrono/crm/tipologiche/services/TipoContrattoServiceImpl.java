package it.sincrono.crm.tipologiche.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sincrono.crm.domain.entities.TipoContratto;
import it.sincrono.crm.tipologiche.repositories.TipoContrattoRepository;

@Service
public class TipoContrattoServiceImpl implements TipoContrattoService {
	@Autowired
	private TipoContrattoRepository repository;

	@Override
	public List<TipoContratto> getAll() {
		return repository.findAll();
	}

	@Override
	public TipoContratto getOne(Integer id) {
		Optional<TipoContratto> optional = repository.findById(id);
		return optional.get();
	}

	@Override
	public void insertOne(TipoContratto tipoContratto) {
		repository.save(tipoContratto);
	}

	@Override
	public void updateOne(TipoContratto tipoContratto) {
		repository.save(tipoContratto);
	}

	@Override
	public void deleteOne(Integer id) {
		repository.deleteById(id);
	}

}
