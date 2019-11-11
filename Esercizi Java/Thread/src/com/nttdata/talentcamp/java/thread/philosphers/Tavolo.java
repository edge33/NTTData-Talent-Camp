package com.nttdata.talentcamp.java.thread.philosphers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tavolo {

	private Bacchetta[] bacchette;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	public Tavolo() {
		this.bacchette = new Bacchetta[5];
		for (int i = 0; i < bacchette.length; i++) {
			bacchette[i] = new Bacchetta();
		}
	}
	
	public Bacchetta[] getBacchette() {
		return bacchette;
	}
	
	public void prendiBacchette(int numero) {
		lock.lock();
		while (bacchette[numero].isOccupata() || bacchette[(numero + 1) % 5].isOccupata()) {
			try {
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bacchette[numero].setOccupata(true);
		bacchette[(numero + 1) % 5].setOccupata(true);
		lock.unlock();
	}
	
	public void lasciaBacchette(int numero) {
		lock.lock();
		bacchette[numero].setOccupata(false);
		bacchette[(numero + 1) % 5].setOccupata(false);
		condition.signalAll();
		lock.unlock();
	}
}
