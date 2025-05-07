package bank;

public class WithdrawThread extends Thread {
    private BankOperationService service;
    private BankAccount account;
    private double amount;

    public WithdrawThread(BankOperationService service, BankAccount account, double amount) {
        this.service = service;
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            System.out.println("Attempting to withdraw ₹" + amount + "...");
            System.out.println("Processing...");
            Thread.sleep(2000); 
            service.withdraw(account, amount);
            System.out.println("Withdrawal successful. Remaining balance: ₹" + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("InsufficientFundsException: Not enough balance to withdraw ₹" + amount);
        } catch (InterruptedException e) {
            System.out.println("Withdrawal interrupted.");
        }
    }
}
