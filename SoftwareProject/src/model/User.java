package model;

import utilities.Encryptor;

public class User {

	int userID = 0;
	String firstName;
	String lastName;
	String email;
	String phone;
	//Address address;
	String login;
	String password;
	Role rolen;
	boolean active;
	
	public enum Role{
		 ADMIN,USER
	}
	
	public User(int userID, String firstName, String lastName, String email, String phone, /*Address address,*/
			String login, String password, Role rolen, boolean active) {
		
		if (firstName == null || lastName == null || email == null || phone == null || login == null || password == null ||
			rolen == null)
			throw new IllegalArgumentException();
		
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		//this.address = address;
		this.login = login;
		this.password = password;
		this.rolen = rolen;
		this.active = active;
	}
	
	public User(String firstName, String lastName, String email, String phone, String login, String password, Role rolen) {
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

	public int setPhone(String phone) {
		if (phone == null)
			//return ErrorCode.NULL_PARAM;
			return 1;
		this.phone = phone;
		//return ErrorCode.NO_ERROR;
		return 2;
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
		if (firstName == null)
			//return ErrorCode.NULL_PARAM;
			return 1;
		this.firstName = firstName;
		//return ErrorCode.NO_ERROR;
		return 2;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int setLastName(String lastName) {
		if (lastName == null)
			//return ErrorCode.NULL_PARAM;
			return 1;
		this.lastName = lastName;
		//return ErrorCode.NO_ERROR;
		return 2;
	}

	public String getEmail() {
		return email;
	}
	
	public int setEmail(String email) {
		if (email == null)
			//return ErrorCode.NULL_PARAM;
			return 1;
		this.email = email;
		//return ErrorCode.NO_ERROR;
		return 2;
	}
	
	/*public Address getAddress() {
		return address;
	}

	public int setAddress(Address address) {
		if (address == null)
			return ErrorCode.NULL_PARAM;
		this.address = address;
		return ErrorCode.NO_ERROR;
	}*/

	public String getLogin() {
		return login;
	}
	
	public int setLogin(String login) {
		if (login == null)
			//return ErrorCode.NULL_PARAM;
			return 1;
		this.login = login;
		//return ErrorCode.NO_ERROR;
		return 2;
	}
	
	/**
	 * 
	 * @param password The plain text password for the user which is authenticated with
	 * @return True if the password matches, false if not.
	 */
	
	public boolean checkPassword(String password) {
		if(this.password.equals(Encryptor.encrypt(password)))
			return true;
		else 
			return false;
	}
	
	public String getPassword() {
		//TODO This needs to be removed
		return password;
	}
	
	public int setPassword(String password) {
		if (password == null)
			//return ErrorCode.NULL_PARAM;
			return 1;
		this.password = password;
		//return ErrorCode.NO_ERROR;
		return 2;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", login=" + login + ", password=" + password + ", rolen=" + rolen + ", active="
				+ active + "]";
	}

	
	
	
}
