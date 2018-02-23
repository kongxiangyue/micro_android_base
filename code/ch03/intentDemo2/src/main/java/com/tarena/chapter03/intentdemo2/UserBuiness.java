package com.tarena.chapter03.intentdemo2;

public class UserBuiness {
	public boolean exists(User user) {
		if (user != null) {
			if ("admin".equals(user.getUserName())
					&& "123456".equals(user.getUserPassword())) {
				return true;
			}
		}
		return false;

	}
}