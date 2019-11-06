package com.nttdata.talentcamp.java.thread.philosphers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bacchetta {

	private boolean occupata = false;
		
	public boolean isOccupata() {
		return this.occupata;
	}
	
	public void setOccupata(boolean occupata) {
		this.occupata = occupata;
	}
}
