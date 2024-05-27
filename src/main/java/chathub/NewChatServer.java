package chathub;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
@Controller
public class NewChatServer {

    @PostMapping("/after-new-ChatServer-btn")
    public static String newChatServerbtn() {
        return "NewChatServer";
    }

    @PostMapping("back-to-overview")
    public static String back_to_overview(Model model) {
        model.addAttribute("ChatServer", ServerOverview.ChatServer_list);
        return "Overview";
    }


    @PostMapping("/after-new-ChatServer")
    public static String newChatServer(@ModelAttribute("chatserver") ChatServer newChatServer, Model model, HttpSession session) throws SQLException, NoSuchAlgorithmException {
        model.addAttribute("ChatServer", ServerOverview.ChatServer_list);
        User user = (User) session.getAttribute("user");
        newChatServer.setPassword(PasswordEncryptor.encrypt(newChatServer.getPassword()));
        SQL.newChatServer(newChatServer, SQL.getUserIdByUsername(user.username));
        model.addAttribute("ChatServer", ServerOverview.getChatServerIntoList());
        return "Overview";
    }
}
