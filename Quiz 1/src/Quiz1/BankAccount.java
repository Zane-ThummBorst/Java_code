package Quiz1;

public class BankAccount {
	private double initialBalance;
	public BankAccount() {
		initialBalance = 0;
	}
	public BankAccount(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	public void deposit(double amount) {
		initialBalance += amount; 
	}
	 public void withdraw(double amount) {
		 if(amount > initialBalance) {
			 throw new IllegalArgumentException("to little Initial Balance");
		 }
		 initialBalance =- amount;
	 }
	 public double getBalance() {
		 return initialBalance;
	 }
	 public void transfer(double amount, BankAccount destination) {
		 if(amount > initialBalance) {
			 throw new IllegalArgumentException("to little Initial Balance");
		 }
		 else {
			 destination.deposit(amount);
			 initialBalance -= amount;
		 }
		 
	 }
	 public void setBalance(double balance) {
		 initialBalance = balance;
	 }
	 public static void main(String[] args) {
		 CheckingAccount sa = new CheckingAccount(.04);
		 sa.deposit(50);
		 System.out.println(sa.getBalance());
	 }
}
