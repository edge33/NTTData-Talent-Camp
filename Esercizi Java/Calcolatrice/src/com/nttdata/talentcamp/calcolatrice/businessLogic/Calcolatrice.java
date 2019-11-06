package com.nttdata.talentcamp.calcolatrice.businessLogic;

public class Calcolatrice {

	public static int somma(int a, int b) {
		return a + b;

	}
	
	public static int differenza (int a, int b) {
		if(a > b) {
			return a - b;
		}
		
		System.out.println("Attenzione: "+a+" e' minore di "+b);
		return -1;
	}
}
