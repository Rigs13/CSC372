package CTA1;

public class CheckingAccount extends BankAccount {
	
	// Additional Attribute of Interest Rate and Overdraft Fee
	private double interestRate;
	private static final double overdraftFee = 30.0;
	
	// Constructor inherited from superclass
	public CheckingAccount() {
		super();
	}
	
	// Additional setter/getter for Interest Rate
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double changeRate) {
		this.interestRate = changeRate;
	}
	
	// Overriding super withdrawal method with inclusion of overdraft fee
	@Override
	public void withdrawal(double amount) {
		if (amount > getBalance()) {
			double totalAmount = amount + overdraftFee;
			super.withdrawal(totalAmount);
			System.out.println("WITHDRAWAL NOTICE: ");
			System.out.println("Overdraft Fee: " + overdraftFee + " has been accessed.");
			System.out.println();
		}
		else {
			super.withdrawal(amount);
		}
	}

	// Display Account Method inheriting from the account summary method in superclass
	public void displayAccount() {
		super.accountSummary();
		System.out.println("Interest Rate: " + interestRate);
		System.out.println();
	}
	
}
