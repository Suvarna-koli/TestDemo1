package com.niit;

public class LoginDAO {

	// write simple method which takes two parameters and return true or false

	public boolean isValidCredentials(String id, String password) {
		// Get the connection
		// write query
		// execute query

		// Temporily assuming that id and password is niit

		if (id.equals("niit") && password.equals("niit")) {
			return true;
		} else {

			return false;
		}

	}

}
