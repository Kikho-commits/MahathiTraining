package employee.service;

import employee.repository.Repository;

public class AuthServiceImpl implements AuthService{
	Repository repository = new Repository();
	@Override
	public int loginAuthenticate(String userName, String password) {
		if(repository.getUsers().containsKey(userName)) {
			if(repository.getUsers().get(userName).getPassword().equals(password)) {
				return repository.getUsers().get(userName).getUserId();
			}else {
				return 0;
			}
		}
		return -1;
	}
}
