package it.nttdata.dao.entity;

import java.io.Serializable;

public class Corsi implements Serializable {

	private static final long serialVersionUID = 1L;

	private int pkIdCorso = 0; 
	private int fkIdCorsoLaurea = 0;
	private String fkTipologia = ""; 
	private int fkIdDocente = 0; 
	private String denominazione = ""; 
	private int cfu = 0; 
	private String settore = ""; 
	private String flagOpzionale = "";
	
	public Corsi() {

	}

	public Corsi(	int pkIdCorso, 
					String denominazione, 
					int cfu, 
					String settore, 
					String fkTipologia, 
					int fkIdCorsoLaurea,
					int fkIdDocente, 
					String flagOpzionale) {
		this.pkIdCorso = pkIdCorso;
		this.denominazione = denominazione;
		this.cfu = cfu;
		this.settore = settore;
		this.fkTipologia = fkTipologia;
		this.fkIdCorsoLaurea = fkIdCorsoLaurea;
		this.fkIdDocente = fkIdDocente;
		this.flagOpzionale = flagOpzionale;
	}

	public int getPkIdCorso() {
		return pkIdCorso;
	}

	public void setPkIdCorso(int pkIdCorso) {
		this.pkIdCorso = pkIdCorso;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public String getSettore() {
		return settore;
	}

	public void setSettore(String settore) {
		this.settore = settore;
	}

	public String getFkTipologia() {
		return fkTipologia;
	}

	public void setFkTipologia(String fkTipologia) {
		this.fkTipologia = fkTipologia;
	}

	public int getFkIdCorsoLaurea() {
		return fkIdCorsoLaurea;
	}

	public void setFkIdCorsoLaurea(int fkIdCorsoLaurea) {
		this.fkIdCorsoLaurea = fkIdCorsoLaurea;
	}

	public int getFkIdDocente() {
		return fkIdDocente;
	}

	public void setFkIdDocente(int fkIdDocente) {
		this.fkIdDocente = fkIdDocente;
	}

	public String getFlagOpzionale() {
		return flagOpzionale;
	}

	public void setFlagOpzionale(String flagOpzionale) {
		this.flagOpzionale = flagOpzionale;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Corsi [pkIdCorso=");
		builder.append(pkIdCorso);
		builder.append(", denominazione=");
		builder.append(denominazione);
		builder.append(", cfu=");
		builder.append(cfu);
		builder.append(", settore=");
		builder.append(settore);
		builder.append(", fkTipologia=");
		builder.append(fkTipologia);
		builder.append(", fkIdCorsoLaurea=");
		builder.append(fkIdCorsoLaurea);
		builder.append(", fkIdDocente=");
		builder.append(fkIdDocente);
		builder.append(", flagOpzionale=");
		builder.append(flagOpzionale);
		builder.append("]");
		return builder.toString();
	}

}
