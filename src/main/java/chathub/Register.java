package chathub;

import jakarta.servlet.http.HttpSession;
import org.apache.catalina.Server;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class Register {
    @GetMapping("/register")
    public static String register() {
        CustomLogger.logCustomInfo("Ein Benutzer ist im Registrier-Bereich!");
        return "Register";
    }

    @PostMapping("/after-register")
    public String after_register(@ModelAttribute("user") User newuser, Model model, HttpSession session) throws SQLException, NoSuchAlgorithmException {
        String password = newuser.getPassword();
        newuser.setPassword(PasswordEncryptor.encrypt(password));

        ResultSet result = SQL.getResult("SELECT * FROM User WHERE username = '" + newuser.username + "';");
        if (result.next()) {
            model.addAttribute("already_registered", "Dieser username existiert bereits!");
            CustomLogger.logCustomInfo("Ein Benutzer hat probiert sich mit einem schon registrierten username zu registrieren!");
            return "Register";
        } else {
            SQL.newUser(newuser);
            CustomLogger.logCustomInfo("Ein neuer Benutzer hat sich registriert und ist jetzt im Server Overview!");
            session.setAttribute("user", newuser);
            MyServerOverview.getChatServer(model, session);
            return "MyChatServers_start";
        }
    }
}
