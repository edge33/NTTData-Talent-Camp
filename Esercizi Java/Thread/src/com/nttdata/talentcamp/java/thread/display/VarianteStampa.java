package com.nttdata.talentcamp.java.thread.display;

public class VarianteStampa implements Runnable {

	private Stampante stampante;
	private int numero;
	private int numeroDiCaratteriDaStampare;
	private char carattereDaStampare;
	
	public VarianteStampa(int numero, char carattereDaStampare, int numeroDiCaratteriDaStampare, Stampante stampante) {
		this.numero = numero;
		this.carattereDaStampare = carattereDaStampare;
		this.numeroDiCaratteriDaStampare = numeroDiCaratteriDaStampare;
		this.stampante = stampante;
	}
	
	@Override
	public void run() {
		System.out.println("il thread " + numero + " è partito...");
		while(true) {			
			this.stampante.stampa(this.carattereDaStampare, this.numeroDiCaratteriDaStampare);
		}
	}
}
