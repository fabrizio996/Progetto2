package it.sincrono.crm.tipologiche.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sincrono.crm.domain.entities.Provincia;
import it.sincrono.crm.tipologiche.repositories.ProvinciaRepository;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {
	@Autowired
	private ProvinciaRepository repository;

	@Override
	public List<Provincia> getAll() {
		return repository.findAll();
	}

	@Override
	public Provincia getOne(Integer id) {
		Optional<Provincia> optional = repository.findById(id);
		return optional.get();
	}

	@Override
	public void insertOne(Provincia provincia) {
		repository.save(provincia);
	}

	@Override
	public void updateOne(Provincia provincia) {
		repository.save(provincia);
	}

	@Override
	public void deleteOne(Integer id) {
		repository.deleteById(id);
	}

}