package Quiz1;

public class CheckingAccount extends BankAccount{
	private double initialBalance;
	static int transactions;
	public CheckingAccount(double intitalBalance) {
		this.initialBalance = initialBalance;
		transactions = 0;
	}
	
	public void withdraw(double amount) {
		 if(amount > initialBalance) {
			 throw new IllegalArgumentException("to little Initial Balance");
		 }
		initialBalance -= amount;
		transactions++;
		this.setBalance(initialBalance);
	}
	
	public void deposit(double amount) {
		initialBalance += amount; 
		transactions++;
		this.setBalance(initialBalance);
	}
	


}
