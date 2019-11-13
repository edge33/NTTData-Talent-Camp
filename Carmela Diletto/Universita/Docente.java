package nttdata.talentcamp.universita;

public class Docente extends Persona {

	private RuoloDocente ruolo;

	public Docente(String codiceFiscale, String nome, String cognome, RuoloDocente ruolo) {
		super(codiceFiscale, nome, cognome);
		this.ruolo = ruolo;
	}

	public RuoloDocente getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloDocente ruolo) {
		this.ruolo = ruolo;
	}

	
	

}
