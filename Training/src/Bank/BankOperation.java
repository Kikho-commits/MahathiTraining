package Bank;

import java.util.ArrayList;

public class BankOperation {
	 ArrayList <User>users = new ArrayList<>();
	    int id = 1;

	    public void createUser(String username,double balance) throws MinBalanceException{
	        if(balance <500){
	            throw new MinBalanceException("Minimum Balance should be ₹500");
	        }
	        User usr = new User(id++,username, balance);
	        users.add(usr);
	        
	    }
	    

	    public User findUser(int id){
	        for(User user : users){
	            if(user.getId() == id){
	                return user;    
	            }
	        }
	        return null;
	    }
	    public void deposit (int id,double amt) throws InvalidInputException{
	        User user=findUser(id);
	        if(amt <= 0){
	            throw new InvalidInputException("Invalid deposit amount");
	        }
	        user.balance += amt;
	        System.out.println("Deposited Amount : ₹" + amt);
	        System.out.println("Available Balance : ₹" + user.getBalance());
	    }
	    
	    public void withdraw(int id, double amt)throws InvalidInputException,InsufficientBalanceException{
	        User user = findUser(id);
	        if(user.balance < amt){
	            throw new InsufficientBalanceException("Insufficient amount"); 
	        }
	        if(amt <= 0){
	            throw new InvalidInputException("Invalid withdraw amount");
	        }
	        user.balance -= amt;
	        System.out.println("Withdrawn Amount : ₹" + amt);
	        System.out.println("Available Balance : ₹" + user.getBalance());
	    }
	    
	    
	    public void checkBalance(int id){
	        User user=findUser(id);
	        user.getBalance();
	    }
	    
	    
	    public void accountDetails(int id){
	        User user=findUser(id);
	        System.out.println("Account id : " + user.getId());
	        System.out.println("Account name : " + user.getUsername());
	        System.out.println("Account balance : ₹" + user.getBalance());
	    }

}
