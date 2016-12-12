package model;

import model.*;
import utilities.Encryptor;
import controller.SystemController;
import data_control.*;

public class SystemNMBS {
	public User logged_user;
	
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
			
			   // Maken van de logfile met text
			String s = "User met id :"+ user.getUserID() +" is succesvol ingelogd";
			LogFile log = new LogFile(s, user.getUserID());
			LogFileDAO.createLogFile(log);
		// Eind maken van logfile
		} else {
			return ErrorCode.INCORRECT_PARAM;
		}
		
		return ErrorCode.NO_ERROR;
	}
	
	public void meldAf() {
		logged_user = null;
	}
}
