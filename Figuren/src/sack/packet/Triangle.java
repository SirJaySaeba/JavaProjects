package sack.packet;

public class Triangle {

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
	
	public double calcArea(){
		return 0.5*laenge*hoehe;
	}
}
