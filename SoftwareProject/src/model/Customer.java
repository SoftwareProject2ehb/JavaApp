package model;

import java.util.HashMap;

import data_control.CustomerDAO;

public class Customer {
	
	private int id = -1;
	private String first_name = null;
	private String last_name = null;
	private String email = null;
	private String phone = null;
	private String address = null;
	
	/**
	 * The constructor for the Customer class, where an id is not specified. In this case, the id should be generated as being the next id in the database table.
	 * @param name The name of the created customer
	 * @param email The email address of the created customer
	 * @param phone The phone number of the created customer
	 * @param address The address of the created customer
	 */
	public Customer(String first_name, String last_name, String email, String phone, String address) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	/**
	 * The constructor for the Customer class, with an primary key id specified.
	 * @param id The primary key id of the created customer
	 * @param name The name of the created customer
	 * @param email The email address of the created customer
	 * @param phone The phone number of the created customer
	 * @param address The address of the created customer
	 */
	public Customer(int id, String first_name, String last_name, String email, String phone, String address) {
		this(first_name, last_name, email, phone, address);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	/**
	 * Setter for the id attribute of Customer
	 * @param id An integer value between 0 and 999.999
	 * @return 0: the set operation succeeded, 100: the id is not between the bounds
	 */
	public int setId(int id) {
		if (id > 999999 || id < 0) {
			return ErrorCode.INCORRECT_PARAM;
		}
		this.id = id;
		return 0;
	}

	/**
	 * Setter for the name attribute of Customer
	 * @param first_name A string value larger than one character and smaller than 100
	 * @param last_name A string value larger than one character and smaller than 100
	 * @return 0: the set operation succeeded, 100: the name parameter is not valid, 200: the name object is NULL
	 */
	public int setName(String first_name, String last_name) {
		if (first_name == null || last_name == null) {
			return ErrorCode.NULL_PARAM;
		}
		if (first_name.length() < 1 || first_name.length() >= 100 || last_name.length() < 1 || last_name.length() >= 100) {
			return ErrorCode.INCORRECT_PARAM;
		}
		this.first_name = first_name;
		this.last_name = last_name;
		return 0;
	}

	/**
	 * Setter for the email attribute of Customer
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

	/**
	 * Setter for the phone attribute of Customer
	 * @param phone A string value larger than one character and smaller than 20
	 * @return 0: the set operation succeeded, 100: the phone parameter is not valid, 200: the phone object is NULL
	 */
	public int setPhone(String phone) {
		if (phone == null) {
			return ErrorCode.NULL_PARAM;
		}
		if (phone.length() < 1 || phone.length() >= 20) {
			return ErrorCode.INCORRECT_PARAM;
		}
		this.phone = phone;
		return 0;
	}
	
	/**
	 * Setter for the address attribute of Customer
	 * @param address A string value larger than one character and smaller than 200
	 * @return 0: the set operation succeeded, 100: the address parameter is not valid, 200: the address object is NULL
	 */
	public int setAddress(String address) {
		if (address == null) {
			return ErrorCode.NULL_PARAM;
		}
		if (address.length() < 1 || address.length() >= 200) {
			return ErrorCode.INCORRECT_PARAM;
		}
		this.address = address;
		return 0;
	}
	
	/**
	 * Method that is used to request information about a customer with a specified id.
	 * @param id An integer value between 0 and 999.999
	 * @return HashMap<String, Object> with the following keys: id; name; address; email; phone.
	 * If the id parameter is out of bounds, a null pointer will be returned.
	 */
	public static HashMap<String, Object> getCustomerInformation(int id) {
		if (id > 999999 || id < 0) {
			return null;
		}
		
		CustomerDAO cd = new CustomerDAO();
		Customer cust = cd.findCustomerById(id);
		//TODO Change this way of working with CustomerDAO, should be a global way
		
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("id", id);
		hashmap.put("address", cust.getAddress());
		hashmap.put("email", cust.getEmail());
		hashmap.put("firstname", cust.getFirstName());
		hashmap.put("lastname", cust.getLastName());
		hashmap.put("phone", cust.getPhone());
		
		return null;
	}
	
}