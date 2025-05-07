package Bank;

public class User {
	 int id;
	    String username;
	    public double balance;
	    
	    public User(int id,String username, double balance){
	        this.id = id;
	        this.username = username;
	        this.balance = balance;
	    }
	    
	    public double getBalance(){
	        return balance;
	    }
	    
	    public int getId(){
	        return id;
	    }
	   
	    
	    public String getUsername(){
	        return username;
	    }
}
