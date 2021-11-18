package it.sincrono.crm.rapportini.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sincrono.crm.domain.entities.Rapportino;
import it.sincrono.crm.rapportini.repository.RapportiniRepository;

@Service
public class RapportinoServiceImpl implements RapportinoService {

	@Autowired
	private RapportiniRepository repository;

	@Override
	public List<Rapportino> findAll() {
		return repository.findAll();
	}

	@Override
	public Rapportino findOne(Integer id) {
		Optional<Rapportino> optional = repository.findById(id);
		return optional.get();
	}

	@Override
	public void insertOne(Rapportino rapportino) {
		repository.save(rapportino);
	}

	@Override
	public Double calcolaStipendio(Integer id, Integer mese) {
		Double stipendio = 0.0;
		List<Timestamp> timestamps = repository.estraiOre(id, mese);
		Double compenso = repository.estraiCompenso(id);
		int i = 0;

		while (i < timestamps.size()) {
			Timestamp entrata = timestamps.get(i);
			Timestamp uscita = timestamps.get(i + 1);

			Long oreLavorative = (uscita.getTime() - entrata.getTime()) / 1000 / 3600;
			stipendio += oreLavorative * compenso;

			i += 2;
		}

		return stipendio;
	}
}
