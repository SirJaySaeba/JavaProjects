import java.text.DecimalFormat;

public class PaymentCalculator {

	private static final double DARLEHEN = 50000;
	private static final double ZINS = 0.0175d;
	private static final double RATE = 406.25;
	private static final double SONDERTILGUNG = 2500.0;

	public static void main(String[] args) {
		double restschuld = DARLEHEN;
		double anteil_zins;
		double anteil_tilgung;
		double zinssumme = 0;
		// int laufzeit =
		// Integer.parseInt(JOptionPane.showInputDialog("Gib eine Laufzeit ein"));
		int laufzeit = 0;

		DecimalFormat df = new DecimalFormat("##.##");

		if (laufzeit > 0) {
			while (laufzeit > 0) {
				anteil_zins = (restschuld * ZINS) / 12;
				zinssumme += (restschuld * ZINS) / 12;
				anteil_tilgung = RATE - anteil_zins;
				restschuld -= anteil_tilgung;
				if (laufzeit % 12 == 0) {
					restschuld -= SONDERTILGUNG;
				}
				laufzeit--;
				System.out.println(restschuld);
			}
			System.out.println("gezahlte Zinsen: " + df.format(zinssumme)
					+ " €");

			System.out.println("Am Ende der Laufzeit bleiben "
					+ df.format(restschuld) + " übrig.");
		} else {
			while (restschuld > 0) {
				anteil_zins = (restschuld * ZINS) / 12;
				zinssumme += (restschuld * ZINS) / 12;
				anteil_tilgung = RATE - anteil_zins;
				restschuld -= anteil_tilgung;
				if (laufzeit != 0 && laufzeit % 12 == 0) {
					restschuld -= SONDERTILGUNG;
				}
				laufzeit++;
				System.out.println(restschuld);
			}

			int jahre = laufzeit / 12;
			int monate = laufzeit % 12;
			System.out.println("gezahlte Zinsen: " + df.format(zinssumme)
					+ " €");
			System.out.println("Die Tilgung würde " + jahre + " Jahre und "
					+ monate + " Monate dauern");
		}

	}

}
