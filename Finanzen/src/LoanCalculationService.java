public class LoanCalculationService {

	private final Loan loan;

	public LoanCalculationService(Loan loan) {
		this.loan = loan;
	}

	public Loan getLoan() {
		return loan;
	}

	public double getRestDept(double restschuld, int laufzeit) {
		double anteil_zins;
		double anteil_tilgung;
		anteil_zins = (restschuld * loan.getInterest()) / 12;
		anteil_tilgung = loan.getInterest() - anteil_zins;
		restschuld -= anteil_tilgung;
		if (loan.getRunTime() % 12 == 0) {
			restschuld -= loan.getUnscheduledPayment();
		}
		return restschuld;
	}

	public double sumUpInterest(double interest, double restschuld) {
		interest += (restschuld * loan.getInterest()) / 12;
		return interest;
	}

	public void payDept(int laufzeit, double restschuld) {
		if (laufzeit > 0) {
			while (laufzeit > 0) {
				laufzeit--;
				System.out.println(restschuld);
			}
			// System.out.println("gezahlte Zinsen: " + df.format(zinssumme) +
			// " €");

			// System.out.println("Am Ende der Laufzeit bleiben " +
			// df.format(restschuld) + " übrig.");
			System.out.println("Am Ende der Laufzeit bleiben " + restschuld + " übrig.");
		} else {
			while (restschuld > 0) {
				System.out.println(restschuld);
			}

			int jahre = laufzeit / 12;
			int monate = laufzeit % 12;
			// System.out.println("gezahlte Zinsen: " + df.format(zinssumme) +
			// " €");
			System.out.println("Die Tilgung würde " + jahre + " Jahre und " + monate + " Monate dauern");
		}
	}

}
