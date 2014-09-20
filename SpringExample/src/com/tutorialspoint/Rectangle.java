package com.tutorialspoint;

public class Rectangle implements Shape {

	private double laenge, breite;
	
	public double getLaenge() {
		return laenge;
	}
	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}
	
	public double getBreite() {
		return breite;
	}
	public void setBreite(double breite) {
		this.breite = breite;
	}
	@Override
	public double calcArea() {		
		return laenge*breite;
	}
	
}
