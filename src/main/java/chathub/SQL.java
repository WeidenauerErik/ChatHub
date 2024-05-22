package chathub;

import java.sql.*;

public class SQL {

    public static Connection connection;

    public static void getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chathub","root","");
        CustomLogger.logCustomInfo("SQL-Verbindung wurde aufgebaut!");
    }

    public static ResultSet getResult(String input) throws SQLException {
        Statement stm = connection.createStatement();
        return stm.executeQuery(input);
    }

    public static ResultSet getAllUser() throws SQLException {
        Statement stm = connection.createStatement();
        return stm.executeQuery("SELECT * FROM User");
    }

    public static void newUser(User user) throws SQLException {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO User (firstname, surname, username, password, is_admin) VALUES (?, ?, ?, ?, false)");
            stm.setString(1, user.firstname);
            stm.setString(2, user.surname);
            stm.setString(3, user.username);
            stm.setString(4, user.password);
            int rowsAffected = stm.executeUpdate();
            stm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static int getNextIndex() throws SQLException {
        ResultSet result = getAllUser();
        int rowCount = 0;
        if (result != null) {
            result.last();
            rowCount = result.getRow();
            result.beforeFirst();
        }
        System.out.println(rowCount);
        return rowCount;
    }
}
