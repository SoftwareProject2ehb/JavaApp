package model;

import model.*;
import data_control.*;

public class SystemNMBS {
	User logged_user;
	
	public SystemNMBS() {
		logged_user = null;
	}
	
	public int login(User user, String password) {
		if (user == null) {
			return ErrorCode.NULL_PARAM;
		}
		
		if (user.checkPassword(password)) {
			logged_user = user;
		}
		
		return ErrorCode.NO_ERROR;
	}
}
