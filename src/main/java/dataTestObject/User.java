package dataTestObject;

public class User {
	private String userId;	
	private String password;
	
	/*
	 * Multiple line comments, below one is called Java doc, how to create Java doc?
	 * slash+**+enter
	 */
	
	/**
	 * 
	 * @param userId String
	 * @param password String
	 */
	
	// parameterized constructor created by variables
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	// by using getter and setter method, we got below methods
	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

}
