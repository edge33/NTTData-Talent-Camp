package com.nttdata.telent.gestioneuniversita;


import java.util.Date;


public class Esame{

		
		private Corso corso;
		private Docente docente;
		private int voto;
		private Date data;
		public Esame(Corso corso, Docente docente, int voto, Date data) {
			super();
			this.corso = corso;
			this.docente = docente;
			this.voto = voto;
			this.data = data;
		}
		public Corso getCorso() {
			return corso;
		}
		public Docente getDocente() {
			return docente;
		}
		public int getVoto() {
			return voto;
		}
		public Date getData() {
			return data;
		}
		public void setCorso(Corso corso) {
			this.corso = corso;
		}
		public void setDocente(Docente docente) {
			this.docente = docente;
		}
		public void setVoto(int voto) {
			this.voto = voto;
		}
		public void setData(Date data) {
			this.data = data;
		}


		
		
		

}
