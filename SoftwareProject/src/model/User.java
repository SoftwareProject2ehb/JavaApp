package model;

public class User extends Address{

	int userID = 0;
	String firstName;
	String lastName;
	String email;
	String phone;
	String login;
	String password;
	Role rolen;
	boolean active;
	
	public enum Role{
		 ADMIN,USER
	}
	/*
	 * The constructor for the User class, with a primary key id specified.
	 */
	public User(int userID, String firstName, String lastName, String email, String phone,String login, 
			String password, Role rolen, boolean active, String street, String number, String bus, 
			int postalCode, String city,String country) {
		
		super(street,number,bus,postalCode,city,country);
		if (firstName == null || lastName == null || email == null || phone == null || login == null || password == null ||
			rolen == null)
			throw new IllegalArgumentException();
		
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.login = login;
		this.password = password;
		this.rolen = rolen;
		this.active = active;
	}
	/**
	 * The constructor for the User class, where an id is not specified. In this case, the id should be generated as being the next id in the database table.
	 * @param firstName The first name of the created user
	 * @param lastName The last name of the created user
	 * @param email	The email of the created user
	 * @param phone The phone number of the created user
	 * @param login	The username of the created user, used to login to application	
	 * @param password The password of the created user, required to login
	 * @param rolen	The role of the created user, either admin or normal user
	 * @param active The status of the created user
	 * @param street The street of the created user
	 * @param number house number of the created user
	 * @param bus The bus code of the created user
	 * @param postalCode The postalcode of the created user
	 * @param city The city of the created user
	 * @param country The country of the created user
	 */
	public User(String firstName, String lastName, String email, String phone, String login, String password, Role rolen, boolean active,
			String street, String number, String bus, int postalCode, String city,String country) {
		super(street,number,bus,postalCode,city,country);
		this.userID = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.login = login;
		this.password = password;
		this.rolen = rolen;
		this.active = true;
	}

	public String getRolen() {
		return this.rolen.name();
	}

	public void setRolen(String rolen) {
		this.rolen = Role.valueOf(rolen);
	}

	public String getPhone() {
		return phone;
	}

	/**
	 * Setter for the phone attribute of User
	 * @param phone A string value larger than one character and smaller than 32
	 * @return 0: the set operation succeeded, 100: the phone parameter is not valid, 200: the phone object is NULL
	 */
	public int setPhone(String phone) {
		if (phone == null) {
			return ErrorCode.NULL_PARAM;
		}
		if (phone.length() < 1 || phone.length() >= 32) {
			return ErrorCode.INCORRECT_PARAM;
		}
		this.phone = phone;
		return 0;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public int setFirstName(String firstName) {
		if (firstName == null) {
			return ErrorCode.NULL_PARAM;
		}
		if (firstName.length() < 1 || firstName.length() >= 100) {
			return ErrorCode.INCORRECT_PARAM;
		}
		this.firstName = firstName;
		return 0;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int setLastName(String lastName) {
		if (lastName == null) {
			return ErrorCode.NULL_PARAM;
		}
		if (lastName.length() < 1 || lastName.length() >= 100) {
			return ErrorCode.INCORRECT_PARAM;
		}
		this.lastName = lastName;
		return 0;
	}

	public String getEmail() {
		return email;
	}
	/**
	 * Setter for the email attribute of User
	 * @param email A string value larger than one character and smaller than 100
	 * @return 0: the set operation succeeded, 100: the email parameter is not valid, 200: the email object is NULL
	 */
	public int setEmail(String email) {
		if (email == null) {
			return ErrorCode.NULL_PARAM;
		}
		if (email.length() < 1 || email.length() >= 100) {
			return ErrorCode.INCORRECT_PARAM;
		}
		this.email = email;
		return 0;
	}
	
	public String getLogin() {
		return login;
	}
	
	public int setLogin(String login) {
		if (login == null) {
			return ErrorCode.NULL_PARAM;
		}
		if (login.length() < 1 || login.length() >= 100) {
			return ErrorCode.INCORRECT_PARAM;
		}
		this.login = login;
		return 0;
	}
	
	/**
	 * 
	 * @param password The plain text password for the user which is authenticated with
	 * @return True if the password matches, false if not.
	 */
	
	public boolean checkPassword(String password) {
		if(this.password.equals(password))
			return true;
		else 
			return false;
	}
	
	public String getPassword() {
		//TODO This needs to be removed
		return password;
	}
	
	public int setPassword(String password) {
		if (password == null) {
			return ErrorCode.NULL_PARAM;
		}
		if (password.length() < 1 || password.length() >= 100) {
			return ErrorCode.INCORRECT_PARAM;
		}
		this.password = password;
		return 0;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return  street + " " + number + ", " + postalCode + " "+ city + " - " + country;
	}

	public String toStringName() {
		return  firstName + " " + lastName;
	}

	
	
	
}
