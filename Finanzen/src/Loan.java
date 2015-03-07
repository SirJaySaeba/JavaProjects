public class Loan {
	private final double loanSum;
	private final double interest;
	private final double runTime;
	private final double unscheduledPayment;
	private final double rate;

	public Loan(double loanSum, double interest, double runTime, double rate) {
		this.loanSum = loanSum;
		this.interest = interest;
		this.runTime = runTime;
		this.unscheduledPayment = loanSum * 0.05;
		this.rate = rate;
	}

	public double getLoanSum() {
		return loanSum;
	}

	public double getInterest() {
		return interest;
	}

	public double getRunTime() {
		return runTime;
	}

	public double getUnscheduledPayment() {
		return unscheduledPayment;
	}

	public double getRate() {
		return rate;
	}
}
