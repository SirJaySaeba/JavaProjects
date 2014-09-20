package com.tutorialspoint;

public class Triangle implements Shape {

	private double laenge, hoehe;
	
	public double getLaenge() {
		return laenge;
	}
	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}
	public double getHoehe() {
		return hoehe;
	}
	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}
	
	@Override
	public double calcArea() {		
		return 0.5*laenge*hoehe;
	}

}
