package com.nttdata.talentcamp.java.thread.philosphers;

public class Main {
	
	public static void main(String[] args) {
	
		Tavolo tavolo = new Tavolo();
		Filosofo f1 = new Filosofo("Socrate", 0, tavolo);
		Filosofo f2 = new Filosofo("Epicuro", 1, tavolo);
		Filosofo f3 = new Filosofo("Kant", 2, tavolo);
		Filosofo f4 = new Filosofo("Aristotele", 3, tavolo);
		Filosofo f5 = new Filosofo("Telesio", 4, tavolo);
		
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
	}
}
