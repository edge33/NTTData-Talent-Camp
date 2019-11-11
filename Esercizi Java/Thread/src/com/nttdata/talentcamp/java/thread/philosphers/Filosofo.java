package com.nttdata.talentcamp.java.thread.philosphers;

import java.util.Random;

public class Filosofo extends Thread {

	private String nome;
	private int numero;
	private Tavolo tavolo;
	private Random random;
	
	public Filosofo(String nome, int numero, Tavolo tavolo) {
		this.nome = nome;
		this.numero = numero;
		this.tavolo = tavolo;
		this.random = new Random();
	}
	
	
	@Override
	public void run() {
		while(true) {
			pensa();
			mangia();
		}
	}
	
	private void pensa() {
		int millisecondi = random.nextInt(1) * 1000;
		System.out.println("Il filosofo " + this.numero + " " + this.nome + " sta pensando per " + millisecondi);
		try {
			Thread.sleep(millisecondi);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Il filosofo " + this.numero + " " + this.nome + " smette di pensare");
	}
	
	private void mangia() {
		System.out.println("Il filosofo " + this.numero + " " + this.nome + " vuole mangiare");
		this.tavolo.prendiBacchette(this.numero);
		System.out.println("Il filosofo " + this.numero + " " + this.nome + " ha preso le bacchette e inizia a mangiare");
		int millisecondi = random.nextInt(1) * 1000;
		try {
			Thread.sleep(millisecondi);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Il filosofo " + this.numero + " " + this.nome + " ha finito di mangiare e lascia le bacchette");
		this.tavolo.lasciaBacchette(this.numero);
	}
	
}
