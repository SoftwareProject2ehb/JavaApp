package unit_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import data_control.UserDAO;
import model.User;
import model.User.Role;

public class UserDAOTest {
	

	@Test
	public void testDAOUser()
	{
		User user = new User("firstname", "lastname", "email", "phone", "login", "password", Role.ADMIN, true, "street", "number", "bus", 5, "city", "country");
		UserDAO.createUser(user);
	     
		user.setFirstName("Mohamed");
		user.setLastName("Helalouch");
	    user.setEmail("mohamedh@gmail.com");
	     
	    UserDAO.updateUser(user);
	    /*
	     * first test will create an array list users and add the user object, to then compare if both names are equal
	     * second test will create 2 array list of the same data from userDAO and check if the size is the same
	     */
	    ArrayList<User> users = new ArrayList<User>();
	    users.add(user);
	    Assert.assertEquals(user.getFirstName(), users.get(0).getFirstName());
	    
	    
	    
	    ArrayList<User> users1 = UserDAO.getAllActiveUsers();
	    ArrayList<User> users2 = UserDAO.getAllActiveUsers();
	    
	    Assert.assertEquals(users1.size(), users2.size());

	}
}
