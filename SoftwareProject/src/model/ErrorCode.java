package model;

public class ErrorCode {
	public static final int NO_ERROR = 0; // Error code used when there is no error
	public static final int INCORRECT_PARAM = 100; // Error code used when there was an incorrect parameter value (ex : a negative price)
	public static final int NULL_PARAM = 200; // Error code used when the parameter is NULL
}