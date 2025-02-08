package pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDataBAse {

	public static void main(String[] args) throws Throwable {

		// step1:-register/load mysql database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		// step2:- connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_bookings", "root", "root");

		// step3:- create SQL statement
		Statement statement = conn.createStatement();
		String query = "insert into booking(id,first_name,last_name,address)values('3','pooja','rawat','goa')";

		// step4:- execute query
		int result = statement.executeUpdate(query);
		if (result == 1) {
			System.out.println("data is created");
		} else {
			System.out.println("Data is not created");
		}
		// step5:- close the database
		conn.close();

	}

}
