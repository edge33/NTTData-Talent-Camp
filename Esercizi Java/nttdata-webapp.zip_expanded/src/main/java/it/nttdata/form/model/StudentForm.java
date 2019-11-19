package it.nttdata.form.model;

import java.io.Serializable;

public class StudentForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String matricola = "";
	private String fkIdCorsoLaurea = "";
	private String nome = "";
	private String cognome = "";
	private String codiceFiscale = "";
	private String sesso = "";
	private String localita = "";
	private String provincia = "";
	private String dataNascita = null;
	private String telefono = "";
	private String email = "";
	private String dataImmatricolazione = null;
	private String dataCessazione = null;

	public StudentForm() {

	}

	public StudentForm(	String matricola, 
						String fkIdCorsoLaurea, 
						String nome, 
						String cognome, 
						String codiceFiscale,
						String sesso, 
						String localita, 
						String provincia, 
						String dataNascita, 
						String telefono, 
						String email,
						String dataImmatricolazione, 
						String dataCessazione) {
		this.matricola = matricola;
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

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getFkIdCorsoLaurea() {
		return fkIdCorsoLaurea;
	}

	public void setFkIdCorsoLaurea(String fkIdCorsoLaurea) {
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

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
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

	public String getDataImmatricolazione() {
		return dataImmatricolazione;
	}

	public void setDataImmatricolazione(String dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}

	public String getDataCessazione() {
		return dataCessazione;
	}

	public void setDataCessazione(String dataCessazione) {
		this.dataCessazione = dataCessazione;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentForm [matricola=");
		builder.append(matricola);
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
