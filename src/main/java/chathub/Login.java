package chathub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class Login {

    @GetMapping("/login")
    public static String login() {
        CustomLogger.logCustomInfo("Ein Benutzer ist gerade im Login-Bereich!");
        return "Login";
    }

    @PostMapping("/after-login")
    public String after_register(@ModelAttribute("user") User user, Model model) throws NoSuchAlgorithmException, SQLException {
        String password = user.getPassword();
        user.setPassword(PasswordEncryptor.encrypt(password));

        String sql = "SELECT * FROM User WHERE username = '" + user.username + "' AND password = '" + user.password+"';";
        ResultSet result = SQL.getResult(sql);

        if (result.next()) {
            model.addAttribute("user", user);
            NewChatServer.user = user;
            CustomLogger.logCustomInfo("Ein Benutzer hat sich gerade eingeloggt und ist jetzt im Server Overview!");
            ServerOverview.showChatServer(model);
            return "Overview";
        } else {
            model.addAttribute("wrong", "The username or password is incorrect!");
            CustomLogger.logCustomInfo("Es wurde versucht sich einzuloggen!");
            return "Login";
        }
    }
}