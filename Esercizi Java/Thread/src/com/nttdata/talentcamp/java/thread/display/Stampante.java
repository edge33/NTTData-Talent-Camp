package com.nttdata.talentcamp.java.thread.display;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Stampante {

	Lock lock = new ReentrantLock();
	
	public void stampa(char c, int n) {
		lock.lock();
		for (int i = 0; i < n; i++) {
			System.out.print(c);
		}
		System.out.println();
		lock.unlock();
	}
	
}
