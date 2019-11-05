package com.nttdata.talentcamp.calcolatrice.main;

public class Main {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 8;
		
		int somma = Calcolatrice.somma(a,b);
		System.out.println("La somma è:" + somma);
		
		int differenza = Calcolatrice.differenza(a, b);
		System.out.println("La differenza è: " + differenza);
	}

}
