package com.nttdata.talentcamp.java.thread.display;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.println("eseguo il main");
		Random random = new Random();
		
		Stampante stampanteCondivisa = new Stampante();
		
		Thread t1 = new Thread(new VarianteStampa(1, 'a', random.nextInt(10) + 1, stampanteCondivisa));
		Thread t2 = new Thread(new VarianteStampa(1, 'b', random.nextInt(10) + 1, stampanteCondivisa));
		Thread t3 = new Thread(new VarianteStampa(1, 'c', random.nextInt(10) + 1, stampanteCondivisa));
		Thread t4 = new Thread(new VarianteStampa(1, 'd', random.nextInt(10) + 1, stampanteCondivisa));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println("il main termina");
	}
}
