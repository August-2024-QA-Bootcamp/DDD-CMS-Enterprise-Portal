package dddUnitTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

// This is an Unit test to check the connectivity towards database is working or not
// This class is not related to our framework, database will be created before creating framework
public class DBConnectionTest {
	
	@Test
	public void dbConnection() throws SQLException {
		
		/*
		 The steps need to be follow:
		 - Step 1: Register the Database by DriverManager from java.sql
		 - Note: We don't need to register separately -- when we added dependency
		 - Step 2: Connection from java.sql 
		 - Step 3: Statement from java.sql, accept the query and execute the query
		 - Step 4: ResultSet from java.sql
		 */
		
		/*
		 To Find the local host, user id etc from below:
		 PostgreSQL16 --- right click -- properties -- connection	
		 */
				
		// getConnection returns the Connection
		// https://jdbc.postgresql.org/documentation/use/
		
		String createTable = "CREATE TABLE AUGUST2024(USER_ID VARCHAR(30) NOT NULL PRIMARY KEY, PASSWORD VARCHAR(30));";
		String insertData = "INSERT INTO AUGUST2024 (USER_ID, PASSWORD) VALUES ('Narima.tushty@gmail.com', 'Login@123456789'), ('shampa.afroz82@gmail.com', 'ShumuLove$2024&'), ('S_1999', 'Silia19??abcsilia'),('Tasnim609', 'Tt6092332201@123'), ('rubuait525@gmail.com', 'Password$123456'), ('mariabegum2121', 'saimun388556Bd@'),('Shamash1', 'Ronglaal12345!@#$%'), ('Mirza12', 'Johnsleeping11$'), ('shahnazm2252', 'Allah@123456789');"; 
		String runTheQuery = "SELECT * FROM AUGUST2024";
		
		// Change below line accordingly, user id, password, local host
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employees_db", "postgres", "hr");
		// createStatement() return Statement object
		Statement statement = connection.createStatement();
		statement.execute(createTable);
		statement.execute(insertData);
		statement.execute(runTheQuery);
		
		// after execution, the result we got can be returned by statement object. 
		ResultSet resultSet = statement.getResultSet();
		resultSet.next();
		// resultSet.getString(1);  // it will read String from Column 1
		System.out.println(resultSet.getString(2));
		
		// Releases this Connection object's database and JDBC resources immediately instead of waiting for them to be automatically released. 
		connection.close();
	
	}

}
