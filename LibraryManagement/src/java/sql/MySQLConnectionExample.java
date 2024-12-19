import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnectionExample {
    public static void main(String[] args) {
        // Step 3: Define database credentials
        String url = "jdbc:mysql://localhost:3306/LibraryDB"; // Replace "LibraryDB" with your database name
        String user = "root"; // Replace with your username
        String password = "yourpassword"; // Replace with your password

        // Connection, Statement, and ResultSet objects
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 4: Establish the connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");

            // Step 5: Create a statement object to execute queries
            statement = connection.createStatement();
            String query = "SELECT * FROM Books"; // Replace "Books" with your table name

            // Execute the query and process the results
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Book ID: " + resultSet.getInt("id"));
                System.out.println("Book Name: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources to avoid memory leaks
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
