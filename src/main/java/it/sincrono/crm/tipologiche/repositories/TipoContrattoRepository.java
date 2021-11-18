package it.sincrono.crm.tipologiche.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import it.sincrono.crm.domain.entities.TipoContratto;

public interface TipoContrattoRepository extends JpaRepository<TipoContratto, Integer> {
//	@Query(value = "SELECT * FROM tipo_contratto a ")
//	public List<TipoContratto> list();
//
//	@Query(value = "SELECT * FROM tipo_contratto a WHERE a.id = :id")
//	public TipoContratto findById(@Param("id") String id);
	
//	@Query(value = "SELECT a FROM tipo_contratto a WHERE a.descrizione = :descrizione")
//	public TipoContratto findByDescrizione(@Param("descrizione") String descrizione);
//	
}
