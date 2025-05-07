package bank;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		BankOperationService bankOperationService = new BankOperationService();
		Scanner in = new Scanner(System.in);
		try {
			System.out.println("1.New User\n2.Existing User\n3.Exit");
			System.out.println("Enter the choice : ");
			int choice = in.nextInt();
			if(choice < 1 || choice >3) {
				throw new Exception("Invalid Input");
			}
			switch(choice) {
			case 1:
				System.out.println("Enter the bank account number : ");
				String accountNumber = in.next();
				System.out.println("Enter the Account holder name : ");
				String holderName = in.next();
				System.out.println("Enter the initial deposit : ");
				double amount = in.nextDouble();
				bankOperationService.create(accountNumber, holderName, amount);
				break;
			case 2:
				do {
					System.out.println("Enter Account Number : ");
					accountNumber = in.next();
					if(bankOperationService.isAccountExist(accountNumber)) {
						System.out.println("Account Logged in!");
						do {
							System.out.println("1.Check Balance\n2.Withdraw\n3.Deposit\n4.Log Out");
							System.err.println("Enter the operation : ");
							choice  = in.nextInt();
							switch(choice) {
							case 1:
								System.out.println("Balance : "+bankOperationService.checkBalance(bankOperationService.bankAccount.get(accountNumber)));
								break;
							case 2:
								System.out.println("Enter the amount to Withdraw : ");
								amount = in.nextDouble();
								WithdrawThread wt = new WithdrawThread(bankOperationService, bankOperationService.bankAccount.get(accountNumber), amount);
								wt.start();
								break;
							case 3:
								System.out.println("Enter the amount to deposit");
								amount =in.nextDouble();
								bankOperationService.deposit(bankOperationService.bankAccount.get(accountNumber),amount);
								break;
							case 4:
								System.out.println("Loggin off...");
								return;
							}
						}while(true);
						
					}
				}while(true);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
