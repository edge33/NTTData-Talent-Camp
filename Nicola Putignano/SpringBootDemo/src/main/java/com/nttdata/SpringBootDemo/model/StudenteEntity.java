package com.nttdata.SpringBootDemo.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="STUDENTI", schema="JAVA_TALENT")
public class StudenteEntity {

	@Id
	@Column(name = "pk_matricola")
	private String matricola;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;

	@ManyToOne
	@JoinColumn(name = "FK_ID_CORSO_LAUREA", referencedColumnName = "PK_ID_CORSO_LAUREA")
	private CorsoDiLaureaEntity corsoDiLaurea;

	@Column(name = "codice_fiscale")
	private String codiceFiscale;

	@Column(name = "sesso")
	private String sesso;

	@Column(name = "localita")
	private String localita;
	
	@Column(name = "provincia")
	private String provincia;
	
	@Column(name = "email")
	private String email;
		
	@Column(name = "data_nascita")
	@DateTimeFormat (pattern="yyyy-mm-dd")
	private Date dataNascita;
	
	@Column(name = "data_immatricolazione")
	@DateTimeFormat (pattern="yyyy-mm-dd")
	private Date dataImmatricolazione;

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public CorsoDiLaureaEntity getCorsoDiLaurea() {
		return corsoDiLaurea;
	}

	public void setCorsoDiLaurea(CorsoDiLaureaEntity corsoDiLaurea) {
		this.corsoDiLaurea = corsoDiLaurea;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataImmatricolazione() {
		return dataImmatricolazione;
	}

	public void setDataImmatricolazione(Date dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}

}
