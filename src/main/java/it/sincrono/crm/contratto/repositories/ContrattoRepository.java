package it.sincrono.crm.contratto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sincrono.crm.domain.entities.Contratto;

public interface ContrattoRepository extends JpaRepository<Contratto, Integer> {
}