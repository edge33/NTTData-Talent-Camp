package com.nttdata.talent.versioneCorso;

public class Docente extends Persona {
	
		private RuoloDocente ruoloDocente;

		public Docente(String codiceFiscale, String nome, String cognome, RuoloDocente ruoloDocente) {
			super(codiceFiscale, nome, cognome);
			this.ruoloDocente = ruoloDocente;
		}

		public RuoloDocente getRuoloDocente() {
			return ruoloDocente;
		}

		public void setRuoloDocente(RuoloDocente ruoloDocente) {
			this.ruoloDocente = ruoloDocente;
		}	
		
		public String toString() {
			return "Il docente "+this.getNome()+" "+this.getCognome()+" con ruolo: "+this.getRuoloDocente();
		}

}
