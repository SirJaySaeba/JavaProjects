import javax.swing.JOptionPane;

public class PaymentCalculator {

	private static final double DARLEHEN = 50000;
	private static final double ZINS = 0.0153d;
	private static final double RATE = 347.08;
	private static final int LAUFZEIT = Integer.parseInt(JOptionPane.showInputDialog("Gib eine Laufzeit ein"));

	public static void main(String[] args) {

		Loan loan = new Loan(DARLEHEN, ZINS, LAUFZEIT, RATE);
		LoanCalculationService service = new LoanCalculationService(loan);

		service.payDept();

	}

}
