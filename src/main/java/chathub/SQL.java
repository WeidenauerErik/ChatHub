package chathub;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SQL {

    public static Connection connection;

    public static void getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chathub", "root", "");
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
        PreparedStatement stm = connection.prepareStatement("INSERT INTO User (firstname, surname, username, password, is_admin) VALUES (?, ?, ?, ?, false)");
        stm.setString(1, user.firstname);
        stm.setString(2, user.surname);
        stm.setString(3, user.username);
        stm.setString(4, user.password);
        stm.executeUpdate();
        stm.close();
    }

    public static ResultSet getAllServer() throws SQLException {
        Statement stm = connection.createStatement();
        return stm.executeQuery("SELECT * FROM ChatServer");
    }

    public static ResultSet getAllChats() throws SQLException {
        Statement stm = connection.createStatement();
        return stm.executeQuery("SELECT * FROM Chat");
    }

    public static void newChatServer(ChatServer newChatServer, String admin_id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO ChatServer (name,description,shorty,password,admin_id) VALUES (?, ?, ?, ?, ?)");
        stm.setString(1, newChatServer.name);
        stm.setString(2, newChatServer.description);
        stm.setString(3, newChatServer.shorty);
        stm.setString(4, newChatServer.password);
        stm.setString(5, admin_id);
        stm.executeUpdate();
        stm.close();
    }

    public static String getUserIdByUsername(String username) throws SQLException {
        String query = "SELECT user_id FROM User WHERE username = ?";
        PreparedStatement stm = connection.prepareStatement(query);
        stm.setString(1, username);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            String userId = rs.getString("user_id");
            rs.close();
            stm.close();
            return userId;
        } else {
            rs.close();
            stm.close();
            throw new SQLException("User not found");
        }
    }

    public static String getUserMy_chatserverByUsername(String username) throws SQLException {
        String query = "SELECT my_chatserver FROM User WHERE username = ?";
        PreparedStatement stm = connection.prepareStatement(query);
        stm.setString(1, username);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            String my_chatserver = rs.getString("my_chatserver");
            rs.close();
            stm.close();
            return my_chatserver;
        } else {
            rs.close();
            stm.close();
            throw new SQLException("User not found");
        }
    }

    public static String getUser_mychatserverByusername(String username) throws SQLException {
        String query = "SELECT my_chatserver FROM User WHERE username = ?";
        PreparedStatement stm = connection.prepareStatement(query);
        stm.setString(1, username);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            String userId = rs.getString("my_chatserver");
            rs.close();
            stm.close();
            return userId;
        } else {
            rs.close();
            stm.close();
            throw new SQLException("User not found");
        }
    }

    public static void setmy_chatserver(String username, String my_chatserver) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("UPDATE User SET my_chatserver = ? WHERE username = ?");
        stm.setString(1, my_chatserver);
        stm.setString(2, username);
        stm.executeUpdate();
        stm.close();
    }

    public static void add_new_chat(String message,String username, String server_id) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO Chat (message,owner,date,server_id) VALUES (?, ?, ?, ?)");
        stm.setString(1, message);
        stm.setString(2, username);
        stm.setString(3, LocalDate.now().toString());
        stm.setString(4,server_id);
        stm.executeUpdate();
        stm.close();
    }
}
