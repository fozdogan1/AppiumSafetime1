package utilities;

import java.sql.*;

public class PostgreSQLConnection {
    public static String getParent() {
        String dbHost = "safetime-db-server02.cxqcbuei8gzw.us-east-2.rds.amazonaws.com";
        String dbUser = "saferschools_test_user";
        String dbName = "saferschools_test_db";
        String dbPassword = "U6ErRKtOJpmmXkDbNuyMxdRt";

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://" + dbHost + "/" + dbName, dbUser, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        if (connection != null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        String sqlQuery = "SELECT parent_email FROM parentpermission_version LIMIT 1 OFFSET 264";
        try {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                String parentEmail = resultSet.getString("parent_email");
                System.out.println("Parent Email: " + parentEmail);
                PostgreSQLConnection.closeConnection(connection);
                return parentEmail;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PostgreSQLConnection.closeConnection(connection);
        return null;


    }

 /*   public String createStatement(Connection con) {

        PostgreSQLConnection connection = null;
        connection.createStatement();
        String sqlQuery = "SELECT parent_email FROM parentpermission_version LIMIT 1 OFFSET 233";
        try {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                String parentEmail = resultSet.getString("parent_email");
                // Elde edilen değeri kullanabilirsiniz (örneğin, yazdırabilirsiniz).
                System.out.println("Parent Email: " + parentEmail);
                return parentEmail;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
*/
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
