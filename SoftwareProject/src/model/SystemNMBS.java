package model;

import model.*;
import utilities.Encryptor;
import data_control.*;

public class SystemNMBS {
	User logged_user;
	
	public SystemNMBS() {
		logged_user = null;
	}
	
	public int login(String user_login, String password) {
		if (user_login == null) {
			return ErrorCode.NULL_PARAM;
		}
		
		User user = UserDAO.findUserByLogin(user_login);
		
		if (user.checkPassword(Encryptor.encrypt(password))) {
			logged_user = user;
		} else {
			return ErrorCode.INCORRECT_PARAM;
		}
		
		return ErrorCode.NO_ERROR;
	}
}