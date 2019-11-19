package it.nttdata.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Studente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String pkMatricola = "";

	private int fkIdCorsoLaurea = 0;

	private String nome = "";

	private String cognome = "";

	private String codiceFiscale = "";

	private String sesso = "";

	private String localita = "";

	private String provincia = "";

	private Date dataNascita = null;

	private String telefono = "";

	private String email = "";

	private Date dataImmatricolazione = null;

	private Date dataCessazione = null;

	public Studente() {

	}

	public Studente(String pkMatricola, 
					int fkIdCorsoLaurea, 
					String nome, 
					String cognome, 
					String codiceFiscale,
					String sesso, 
					String localita, 
					String provincia, 
					Date dataNascita, 
					String telefono, 
					String email,
					Date dataImmatricolazione, 
					Date dataCessazione) {
		this.pkMatricola = pkMatricola;
		this.fkIdCorsoLaurea = fkIdCorsoLaurea;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.sesso = sesso;
		this.localita = localita;
		this.provincia = provincia;
		this.dataNascita = dataNascita;
		this.telefono = telefono;
		this.email = email;
		this.dataImmatricolazione = dataImmatricolazione;
		this.dataCessazione = dataCessazione;
	}

	public String getPkMatricola() {
		return pkMatricola;
	}

	public void setPkMatricola(String pkMatricola) {
		this.pkMatricola = pkMatricola;
	}

	public int getFkIdCorsoLaurea() {
		return fkIdCorsoLaurea;
	}

	public void setFkIdCorsoLaurea(int fkIdCorsoLaurea) {
		this.fkIdCorsoLaurea = fkIdCorsoLaurea;
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataImmatricolazione() {
		return dataImmatricolazione;
	}

	public void setDataImmatricolazione(Date dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}

	public Date getDataCessazione() {
		return dataCessazione;
	}

	public void setDataCessazione(Date dataCessazione) {
		this.dataCessazione = dataCessazione;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Studente [pkMatricola=");
		builder.append(pkMatricola);
		builder.append(", fkIdCorsoLaurea=");
		builder.append(fkIdCorsoLaurea);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cognome=");
		builder.append(cognome);
		builder.append(", codiceFiscale=");
		builder.append(codiceFiscale);
		builder.append(", sesso=");
		builder.append(sesso);
		builder.append(", localita=");
		builder.append(localita);
		builder.append(", provincia=");
		builder.append(provincia);
		builder.append(", dataNascita=");
		builder.append(dataNascita);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", email=");
		builder.append(email);
		builder.append(", dataImmatricolazione=");
		builder.append(dataImmatricolazione);
		builder.append(", dataCessazione=");
		builder.append(dataCessazione);
		builder.append("]");
		return builder.toString();
	}
}
