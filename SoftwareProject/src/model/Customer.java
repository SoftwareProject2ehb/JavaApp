package model;

import java.util.HashMap;

public class Customer {
	
	private int id = -1;
	private String name = null;
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
	public Customer(String name, String email, String phone, String address) {
		this.id = -1;	//TODO
		this.name = name;
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
	public Customer(int id, String name, String email, String phone, String address) {
		this(name, email, phone, address);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
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
			return 100;
		}
		this.id = id;
		return 0;
	}

	/**
	 * Setter for the name attribute of Customer
	 * @param name A string value larger than one character and smaller than 100
	 * @return 0: the set operation succeeded, 100: the name parameter is not valid, 200: the name object is NULL
	 */
	public int setName(String name) {
		if (name == null) {
			return 200;
		}
		if (name.length() < 1 || name.length() >= 100) {
			return 100;
		}
		this.name = name;
		return 0;
	}

	/**
	 * Setter for the email attribute of Customer
	 * @param email A string value larger than one character and smaller than 100
	 * @return 0: the set operation succeeded, 100: the email parameter is not valid, 200: the email object is NULL
	 */
	public int setEmail(String email) {
		if (email == null) {
			return 200;
		}
		if (email.length() < 1 || email.length() >= 100) {
			return 100;
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
			return 200;
		}
		if (phone.length() < 1 || phone.length() >= 20) {
			return 100;
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
			return 200;
		}
		if (address.length() < 1 || address.length() >= 200) {
			return 100;
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
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("id", id);
		hashmap.put("address", "address");
		hashmap.put("email", "email");
		hashmap.put("name", "name");
		hashmap.put("phone", "phone");
		//TODO Replace the key values with Customer-specific information, retrieved from the id parameter
		
		return null;
	}
	
}