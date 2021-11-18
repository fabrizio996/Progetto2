package it.sincrono.crm.anagrafica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.sincrono.crm.domain.entities.Anagrafica;

public interface AnagraficaRepository extends JpaRepository<Anagrafica, Integer> {

	@Query(value = "SELECT * FROM anagrafiche a", nativeQuery = true)
	public List<Anagrafica> findAll();

	@Query(value = "SELECT * FROM anagrafiche a WHERE a.id = :id", nativeQuery = true)
	public Anagrafica findOne(Integer id);
}
