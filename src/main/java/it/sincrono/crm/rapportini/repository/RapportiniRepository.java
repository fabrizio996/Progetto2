package it.sincrono.crm.rapportini.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.sincrono.crm.domain.entities.Rapportino;

public interface RapportiniRepository extends JpaRepository<Rapportino, Integer> {

	@Query(value = "SELECT a.data_orario FROM accessi_badge a WHERE a.id_anagrafica = :id AND MONTH(a.data_orario) = :mese", nativeQuery = true)
	List<Timestamp> estraiOre(Integer id, Integer mese);

	@Query(value = "SELECT a.ral / 220 / 8 FROM contratti a WHERE a.id_anagrafica = :id", nativeQuery = true)
	Double estraiCompenso(Integer id);

}
