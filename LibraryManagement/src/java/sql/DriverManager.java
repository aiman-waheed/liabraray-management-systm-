package java.sql;

public class DriverManager {
	Connection connection = null

	try {
	    connection = DriverManager.getConnection(url, user, password);
	    System.out.println("Connected to the database successfully!");
	} catch (SQLException e) {
	    System.out.println("Connection failed!");
	    e.printStackTrace();
	}
	public static Connection getConnection(String url, String user, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
