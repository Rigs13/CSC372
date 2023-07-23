package CTA1;

public class Main {

	public static void main(String[] args) {
		
		// initialize instance of checking account
		CheckingAccount testAccount = new CheckingAccount();
		
		// test of setters
		testAccount.setFirstName("Semisi");
		testAccount.setLastName("Rigby");
		testAccount.setAccountID(100001);
		testAccount.setInterestRate(3.0);
		
		// test deposit method
		System.out.println("Depositing 100 and displaying Account Info:");
		testAccount.deposit(100);
		testAccount.displayAccount();

		// withdrawal testing
		System.out.println("Withdrawing 50 (No Overdraft application):");
		testAccount.withdrawal(50);
		testAccount.displayAccount();
		
		// overdraft testing
		System.out.println("Withdrawing 100 (Additional Overdraft Charge application):");
		testAccount.withdrawal(100);
		testAccount.displayAccount();
		
	}

}
