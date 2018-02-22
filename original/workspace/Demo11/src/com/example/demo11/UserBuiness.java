package com.example.demo11;

public class UserBuiness {

	public boolean exists(User user) {
		if (user != null) {
			if (user.getUserName().equals("admin")
					&& user.getUserPassword().equals("123456")) {
				return true;
			}
		}
		return false;
	}
}
