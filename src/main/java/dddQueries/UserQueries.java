package dddQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataTestObject.User;
import dddUtils.DBUtility;

public class UserQueries {
	static DBUtility dbUtility; // why static see line 20
	
	public static void init() { // why static see line 20
		dbUtility = new DBUtility();
		// When we will create object from DBUtility class, the constructor of DBUtility will be initialized
		// Constructor contain getConnection() method to connect the database
	}
	
	// We made the method static to call this method by the class directly during test
	public static List<User> getUsers(){
		List<User>listOfUsers = new ArrayList<>();
		init();
		String query = "SELECT * FROM AUGUST2024"; 
		dbUtility.executeQuery(query);
		ResultSet resultSet = dbUtility.getResultSet();		
		try {
			while(resultSet.next()) {
				String userId = resultSet.getString(1); 
				String password = resultSet.getString(2); 
				User user = new User(userId, password);
				listOfUsers.add(user);
			}
			dbUtility.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return listOfUsers;
	}

	
	
	
	
}
