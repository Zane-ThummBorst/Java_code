package Quiz1;

public class SavingsAccount extends BankAccount{
	private double rate;
	private double balance;

	
	public SavingsAccount( double rate) {
		balance = 0;
		this.rate = rate;
		
	}
	void addInterest() {
		double adder = balance*rate;
		balance+= adder;
	}

}
