package sack.packet;

public class Rectangle {

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



	public double calcArea(){
		return laenge * breite;
	}
}
