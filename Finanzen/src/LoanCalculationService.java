import java.text.DecimalFormat;

public class LoanCalculationService {

	private static final int MONTHS = 12;

	private final Loan loan;
	private final DecimalFormat decimalFormatter;

	public LoanCalculationService(Loan loan) {
		this.loan = loan;
		this.decimalFormatter = new DecimalFormat("##.##");
	}

	public Loan getLoan() {
		return loan;
	}

	private double getRestDept(double restschuld, int laufzeit) {
		double anteil_zins;
		double anteil_tilgung;
		anteil_zins = getInterestShare(restschuld);
		anteil_tilgung = loan.getRate() - anteil_zins;
		restschuld -= anteil_tilgung;
		if (laufzeit != 0 && laufzeit % MONTHS == 0) {
			restschuld -= loan.getUnscheduledPayment();
		}
		return restschuld;
	}

	private double sumUpInterest(double payedInterest, double restschuld) {
		payedInterest += getInterestShare(restschuld);
		return payedInterest;
	}

	private double getInterestShare(double restschuld) {
		return (restschuld * loan.getInterest()) / MONTHS;
	}

	public void payDept() {
		int laufzeit = loan.getSuggestedRuntime();
		double payedInterest = 0.0d;
		double restschuld = loan.getLoanSum();
		int years = 0;
		int months = 0;

		if (laufzeit > 0) {

			while (laufzeit > 0) {
				payedInterest = sumUpInterest(payedInterest, restschuld);
				restschuld = getRestDept(restschuld, laufzeit);
				laufzeit--;
			}

			System.out.println("Am Ende der Laufzeit bleiben " + decimalFormatter.format(restschuld) + " übrig.");
		} else {

			while (restschuld > 0) {
				payedInterest = sumUpInterest(payedInterest, restschuld);
				restschuld = getRestDept(restschuld, laufzeit);
				laufzeit++;
			}
			years = getMonthsInYears(laufzeit)[0];
			months = getMonthsInYears(laufzeit)[1];

			System.out.println("Die Tilgung würde " + years + " Jahre und " + months + " Monate dauern");
		}

		loan.setPayedInterest(payedInterest);
		loan.setRestDept(restschuld);
		loan.setActualRuntime(laufzeit);

		System.out.println("gezahlte Zinsen: " + decimalFormatter.format(payedInterest) + " €");
		// System.out.println("gezahlte Zinsen: " + payedInterest + " €");
	}

	private int[] getMonthsInYears(int laufzeit) {
		int[] runtimeFormatted = new int[2];
		// full years
		runtimeFormatted[0] = laufzeit / MONTHS;
		// remaining months
		runtimeFormatted[1] = laufzeit % MONTHS;
		return runtimeFormatted;
	}

}
