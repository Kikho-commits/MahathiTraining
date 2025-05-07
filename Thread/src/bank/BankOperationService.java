package bank;

import java.util.HashMap;

public class BankOperationService {
	HashMap<String,BankAccount> bankAccount = new HashMap<>();

	public BankOperationService() {
		bankAccount.put("123",new BankAccount("123", "Kishore",1000.00));
		bankAccount.put("456",new BankAccount("456", "Porsh",1500.00));
		bankAccount.put("789",new BankAccount("789", "Kikho",2500.00));
		
	}
	public void create(String accountHolder, String accountNumber, double balance) throws Exception {
		if(bankAccount.containsKey(accountNumber)) {
			throw new Exception("Account already exist");
		}else {
			bankAccount.put(accountNumber, new BankAccount(accountHolder,accountNumber,balance));
			System.out.println("Account created Successfully!");
		}
	}
	
	public void withdraw(BankAccount ba,double amount ) throws InsufficientFundsException {
			if(ba.getBalance()<amount) {
				throw new InsufficientFundsException();
			}else {
				System.out.println("Withdrawing "+amount+"...");
				ba.setBalance(ba.getBalance()-amount);
			}
	}
	
	public void deposit(BankAccount ba,double amount) {
		ba.setBalance(ba.getBalance()+amount);
	}
	
	public double checkBalance(BankAccount ba) {
		return ba.getBalance();
	}
	
	public boolean isAccountExist(String accountNumber) {
		if(bankAccount.containsKey(accountNumber)) {
			return true;
		}
		return false;
	}
}
