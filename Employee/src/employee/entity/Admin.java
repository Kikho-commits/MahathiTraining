package employee.entity;

public class Admin {
	private static int userId;
	private static String userName;
	private static String password;
	public Admin(int userId, String userName, String password) {
		super();
		Admin.userId = userId;
		Admin.userName = userName;
		Admin.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
}
