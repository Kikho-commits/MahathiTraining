package bank;

public class BankAccount {
	private String accountHolder;
	private String accountNumber;
	private double balance;
	public BankAccount(String accountHolder, String accountNumber, double balance) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	double getBalance() {
		return balance;
	}
	void setBalance(double balance) {
		this.balance = balance;
	}
	String getAccountHolder() {
		return accountHolder;
	}
	String getAccountNumber() {
		return accountNumber;
	}
	
}
