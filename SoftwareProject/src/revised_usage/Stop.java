package model;

public class Stop {
	private int trainID;
	private int stopID;
	private String name;
	private int platform;
	
	public Stop(int trainID, int stopID, String name, int platform)
	{
		if(trainID < 0 || stopID < 0 ||name == null || platform < 1)
			throw new IllegalArgumentException();
		this.trainID = trainID;
		this.stopID = stopID;
		this.name = name;
		this.platform = platform;
	}
	
	public Stop(int trainID, String name, int platform)
	{
		if(trainID < 0 || stopID < 0 ||name == null || platform < 1)
			throw new IllegalArgumentException();
		this.trainID = trainID;
		this.stopID = -1;
		this.name = name;
		this.platform = platform;
	}
	
	public int getTrainID() {
		return trainID;
	}
	
	public int setTrainID(int trainID) {
		if(trainID < 0)
			return ErrorCode.INCORRECT_PARAM;
		this.trainID = trainID;
		return ErrorCode.NO_ERROR;
	}
	
	public int getStopID()
	{
		return stopID;
	}
	
	public int setStopID(int stopID)
	{
		if(stopID < 0)
			return ErrorCode.INCORRECT_PARAM;
		this.stopID = stopID;
		return ErrorCode.NO_ERROR;
	}
	
	public String getName() {
		return name;
	}
	
	public int setName(String name) {
		if(name == null)
			return ErrorCode.NULL_PARAM;
		this.name = name;
		return ErrorCode.NO_ERROR;
	}
	
	public int getPlatform() {
		return platform;
	}
	
	public int setPlatform(int platform) {
		if(platform < 1)
			return ErrorCode.INCORRECT_PARAM;
		this.platform = platform;
		return ErrorCode.NO_ERROR;
	}
	
	
}
