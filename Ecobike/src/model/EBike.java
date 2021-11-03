package model;

import java.util.Random;

public class EBike extends Bike {
	
	private int bateryPercentage;
	private int loadCycles;
	private int timeRemaining;


	public EBike() {
		super("EBike");
		int bateryPercent = new Random().nextInt(100)+50;
		this.bateryPercentage = bateryPercent;
		this.loadCycles = new Random().nextInt(1000)+5;
		this.timeRemaining = bateryPercent*5;
	}

	public int getBateryPercentage() {
		return bateryPercentage;
	}

	public void setBateryPercentage(int bateryPercentage) {
		this.bateryPercentage = bateryPercentage;
	}

	public int getLoadCycles() {
		return loadCycles;
	}

	public void setLoadCycles(int loadCycles) {
		this.loadCycles = loadCycles;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
}
