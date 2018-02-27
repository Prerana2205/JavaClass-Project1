package proj1;

public class Calculate {

	private int creditScore;
	private double carPrice;
	private double downPayment;
	private double interestRate;
	private int numberOfMonths;
	private double monthlyInterestRate;
	private double loanRemaining;
	private double monthlyPayment;
	private double remPayment;
	private double lastMonthPayment;

	// constructor to be implemented
	public Calculate(int ecreditScore, double ecarPrice, double edownPayment, double einterestRate,
			int numberOfMonths) {
		monthlyInterestRate = interestRate / 12;

	}

	// Calculates monthly payment
	// to be implemented
	public double calcMonthlyPayments() {

		monthlyPayment = (monthlyInterestRate * carPrice) / (1 - Math.pow((1 + monthlyInterestRate), numberOfMonths));
		System.out.println("\nMonthlyPayment is: " + monthlyPayment);
		remPayment = carPrice - (monthlyPayment * numberOfMonths);

		if (remPayment > 0) {
			lastMonthPayment = monthlyPayment + remPayment;
			System.out.println("Monthly payments for the first " + (numberOfMonths - 1) + "are $" + monthlyPayment
					+ " and Last month payment is $" + lastMonthPayment);
		} else {
			lastMonthPayment = monthlyPayment;
			System.out.println("Monthly payment is $" + monthlyPayment + "for " + numberOfMonths + " months");
		}
		return monthlyPayment;
	}

	public double calcTotalAmountPaid() {
		loanRemaining = carPrice;
		double interestPaymentCurrentMonth;
		double principlePaymentCurrentMonth;
		double totalPrinciple = 0.0;
		double totalInterest = 0.0;

		for (int i = 0; i < numberOfMonths; i++) {
			interestPaymentCurrentMonth = loanRemaining * monthlyInterestRate / 100;
			principlePaymentCurrentMonth = monthlyPayment - interestPaymentCurrentMonth;
			loanRemaining = loanRemaining - principlePaymentCurrentMonth;
			totalPrinciple = totalPrinciple + principlePaymentCurrentMonth;
			totalInterest = totalInterest + interestPaymentCurrentMonth;
		}

		if (remPayment > 0) {
			totalPrinciple = totalPrinciple + remPayment;
		}

		System.out.println("Total Principle Paid: $" + totalPrinciple + "\nTotal Interest Paid: $" + totalInterest);

		return 0.0;

	}

	public double calcTotalInterestPaid() {
		return 0.0;
	}

}
