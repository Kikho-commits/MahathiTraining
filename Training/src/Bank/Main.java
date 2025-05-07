package Bank;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
        BankOperation obj = new BankOperation();
        try{
         obj.createUser("Kishore",200);
         obj.deposit(1,1000);
         obj.withdraw(1,-9);
         obj.withdraw(1,55);
         obj.accountDetails(1);
        }catch(MinBalanceException e){
            System.out.println(e.getMessage());
       }catch(InvalidInputException e){
            System.out.println(e.getMessage());
        }catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }t
        
    }
}
