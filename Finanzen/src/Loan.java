public class Loan {

	// initial preconditions
	private final double loanSum;
	private final double interest;
	private final int suggestedRuntime;

	private final double unscheduledPayment;
	private final double rate;

	// attributes for later on
	private double payedInterest;
	private double restDept;
	private int actualRuntime;

	public Loan(double loanSum, double interest, int runTime, double rate) {
		final double UNSCHEDULED_PAYMENT_PART = 0.05d;

		this.loanSum = loanSum;
		this.interest = interest;
		this.suggestedRuntime = runTime;
		this.unscheduledPayment = loanSum * UNSCHEDULED_PAYMENT_PART;
		this.rate = rate;
	}

	public int getSuggestedRuntime() {
		return suggestedRuntime;
	}

	public double getPayedInterest() {
		return payedInterest;
	}

	public void setPayedInterest(double payedInterest) {
		this.payedInterest = payedInterest;
	}

	public int getActualRuntime() {
		return actualRuntime;
	}

	public void setActualRuntime(int actualRuntime) {
		this.actualRuntime = actualRuntime;
	}

	public double getRestDept() {
		return restDept;
	}

	public void setRestDept(double restDept) {
		this.restDept = restDept;
	}

	public double getLoanSum() {
		return loanSum;
	}

	public double getInterest() {
		return interest;
	}

	public double getUnscheduledPayment() {
		return unscheduledPayment;
	}

	public double getRate() {
		return rate;
	}
}
