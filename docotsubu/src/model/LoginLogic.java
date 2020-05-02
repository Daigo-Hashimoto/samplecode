package model;

public class LoginLogic {
	public boolean excute(User user) {
		if(user.getpass().equals("1234")) {return true;}
		return false;
	}
}
