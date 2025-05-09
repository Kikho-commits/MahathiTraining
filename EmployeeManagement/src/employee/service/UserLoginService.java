package employee.service;

public class UserLoginService {
	private static String currentUser;
	private static int role;
	

	public static int getRole() {
		return role;
	}

	public static void setRole(int role) {
		UserLoginService.role = role;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		UserLoginService.currentUser = currentUser;
	}
}
