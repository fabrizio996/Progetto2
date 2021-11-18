package it.sincrono.crm.contratto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sincrono.crm.contratto.repositories.ContrattoRepository;
import it.sincrono.crm.domain.entities.Contratto;

@Service
public class ContrattoServiceImpl implements ContrattoService {
	@Autowired
	private ContrattoRepository repository;

	@Override
	public List<Contratto> findAll() {
		return repository.findAll();
	}

	@Override
	public Contratto findOne(Integer id) {
		Optional<Contratto> optional = repository.findById(id);

		return optional.get();
	}

	@Override
	public void insert(Contratto contratto) {
		repository.save(contratto);
	}

	@Override
	public void update(Contratto contratto) {
		repository.save(contratto);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
