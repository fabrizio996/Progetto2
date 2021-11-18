package it.sincrono.crm.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "anagrafiche")
public class Anagrafica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome")
	@NotBlank(message = "il nome è obbligatorio")
	private String nome;

	@Column(name = "cognome")
	@NotBlank(message = "il cognome è obbligatorio")
	private String cognome;

	@Column(name = "codice_fiscale")
	@NotBlank(message = "il codice fiscale è obbligatorio")
	private String codiceFiscale;

	@Column(name = "eta")
	@NotNull(message = "l'età è obbligatoria")
	private Integer eta;

	@Column(name = "sesso")
	@NotBlank(message = "il sesso è obbligatorio")
	private String sesso;

	@Column(name = "categoria_protetta")
	@NotNull(message = "la categoria protetta è obbligatoria")
	private Boolean categoriaProtetta;

	@Column(name = "curriculum")
	@NotBlank(message = "il curriculum è obbligatorio")
	private String curriculum;

	@NotNull(message = "la provincia è obbligatoria")
	@ManyToOne
	@JoinColumn(name = "id_provincia")
	private Provincia provincia;
}