package sack.packet;

public class MainApp {

	public static void main(String[] args) {

		Rectangle r1 = new Rectangle();
		r1.setBreite(17);
		r1.setLaenge(15);
		System.out.println("Die Fläche des Rechtecks beträgt "+r1.calcArea());
	}

}
