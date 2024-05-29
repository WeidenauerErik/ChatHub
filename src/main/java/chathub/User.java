package chathub;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class User {
    String firstname;
    String surname;
    String username;
    String email;
    String password;
    String my_chatserver;

    public User(String firstname, String surname, String username, String email, String password, String my_chatserver) {
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.my_chatserver = my_chatserver;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMy_chatserver() {
        return my_chatserver;
    }

    public void setMy_chatserver(String my_chatserver) {
        this.my_chatserver = my_chatserver;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", my_chatserver='" + my_chatserver + '\'' +
                '}';
    }
}
