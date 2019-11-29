package com.nttdata.SpringBootDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CORSO_LAUREA", schema="JAVA_TALENT")
public class CorsoDiLaureaEntity {

	@Id
	@Column(name = "PK_ID_CORSO_LAUREA")
	private Long id;

	@Column(name = "fk_id_dipartimento")
	private Long dipartimento;

	@Column(name= "DENOMINAZIONE")
	private String denominazione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Long dipartimento) {
		this.dipartimento = dipartimento;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

}
