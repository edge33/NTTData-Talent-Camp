package nttdata.talentcamp.universita;

public class Esame {
	private Corso corso;
	private Docente docente;
	private int voto;
	

	
	public Esame(Corso corso, Docente docente, int voto) {
		super();
		this.corso = corso;
		this.docente = docente;
		this.voto = voto;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	@Override
	public String toString() {
		return "Esame [corso=" + corso + "]";
	}
	
	

}
