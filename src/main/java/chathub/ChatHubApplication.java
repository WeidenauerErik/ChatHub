package chathub;

import org.apache.catalina.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Controller
public class ChatHubApplication {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SpringApplication.run(ChatHubApplication.class, args);
        SQL.getConnection();
    }

    @GetMapping("/")
    public static String landingpage() {
        return "Landing_Page";
    }
}
