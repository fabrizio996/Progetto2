package it.sincrono.crm.tipologiche.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import it.sincrono.crm.domain.entities.Provincia;


public interface ProvinciaRepository extends JpaRepository<Provincia, Integer>{
//	@Query(value = "SELECT * FROM Province a ")
//	public List<Provincia> list();
//
//	@Query(value = "SELECT * FROM Province a WHERE a.id = :id")
//	public Provincia findById(@Param("id") Integer id);
	
//	@Query(value = "SELECT a FROM Province a WHERE a.descrizione = :descrizione")
//	public Provincia findByDescrizione(@Param("descrizione") String descrizione);
	
}
