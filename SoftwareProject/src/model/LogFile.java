package model;

import java.sql.Timestamp;
import java.util.Date;

public class LogFile {
	private int logFileID;
	private String description;
	private Timestamp time;
	private int userID;
	
	public LogFile(int logFileID, String description, Timestamp time, int userID)
	{
		if(logFileID < 0 || description == null || time == null || userID < 0)
			throw new IllegalArgumentException();
		this.logFileID = logFileID;
		this.description = description;
		this.time = time;
		this.userID = userID;
	}
	
	public LogFile(String description, Timestamp time, int userID)
	{
		if(logFileID < 0 || description == null || time == null || userID < 0)
			throw new IllegalArgumentException();
		this.logFileID = -1;
		this.description = description;
		this.time = time;
		this.userID = userID;
	}
	
	public LogFile(String description, int userID)
	{
		
		this.logFileID = -1;
		this.description = description;
		this.time = new java.sql.Timestamp(new java.util.Date().getTime());
		this.userID = userID;
	}

	public int getLogFileID() {
		return logFileID;
	}

	public int setLogFileID(int logFileID) {
		if(logFileID < 0)
			return ErrorCode.INCORRECT_PARAM;
		this.logFileID = logFileID;
		return ErrorCode.NO_ERROR;
	}

	public String getDescription() {
		return description;
	}

	public int setDescription(String description) {
		if(description == null)
			return ErrorCode.NULL_PARAM;
		this.description = description;
		return ErrorCode.NO_ERROR;
	}

	public Timestamp getTime() {
		return time;
	}

	public int setTime(Timestamp time) {
		if(time == null)
			return ErrorCode.NULL_PARAM;
		this.time = time;
		return ErrorCode.NO_ERROR;
	}

	public int getUserID() {
		return userID;
	}

	public int setUserID(int userID) {
		if(userID < 0)
			return ErrorCode.INCORRECT_PARAM;
		this.userID = userID;
		return ErrorCode.NO_ERROR;
	}
	
}
