package CTA1;

public class BankAccount {
	
	// Attributes
	private String firstName;
	private String lastName;
	private int accountID;
	private double balance;
	
	// Default constructor
	public BankAccount() {
		balance = 0;
	}
	
	// Parameterized Constructor
	public BankAccount(String firstName, String lastName, int accountID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		balance = 0;
	}
	
	// Deposit Method
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	// Withdrawal Method
	public void withdrawal(double amount) {
		balance = balance - amount;
	}
	
	// Setters/Getters
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAccountID() {
		return accountID;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	// Getter for Balance
	public double getBalance() { 
		return balance;
	}
	
	// Account Summary Method
	public void accountSummary() {
		System.out.println("Summary of Account: ");
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("AccountID: " + accountID);
		System.out.println("Balance: " + balance);
	}
	
}
