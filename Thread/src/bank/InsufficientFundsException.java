package bank;

public class InsufficientFundsException extends Exception{
	public InsufficientFundsException() {
		super("Insufficeient fund");
	}

}
