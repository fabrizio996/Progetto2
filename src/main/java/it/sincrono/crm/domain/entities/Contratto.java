package it.sincrono.crm.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "contratti")
public class Contratto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "matricola_utente")
	private String matricolaUtente;

	@Column(name = "data_inizio")
	private Date dataInizio;

	@Column(name = "data_fine")
	private Date dataFine;

	@Column(name = "mansione")
	private String mansione;

	@Column(name = "ral")
	private Double ral;

	@ManyToOne
	@JoinColumn(name = "id_anagrafica")
	private Anagrafica anagrafica;

	@ManyToOne
	@JoinColumn(name = "id_sede_lavoro")
	private Provincia sedeLavoro;

	@ManyToOne
	@JoinColumn(name = "id_tipo_contratto")
	private TipoContratto tipoContratto;

}