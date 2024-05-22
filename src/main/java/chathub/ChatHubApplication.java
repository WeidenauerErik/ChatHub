package chathub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Controller
public class ChatHubApplication {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SQL.getConnection();
        SpringApplication.run(ChatHubApplication.class, args);
    }


}
