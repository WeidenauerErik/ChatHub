package chathub;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
@Controller
public class NewChatServer {

    @PostMapping("/after-new-ChatServer-btn")
    public static String newChatServerbtn(@ModelAttribute("user") User newuser, Model model) {
        return "NewChatServer";
    }

    @PostMapping("back-to-overview")
    public static String back_to_overview(Model model) {
        model.addAttribute("ChatServer", ServerOverview.ChatServer_list);
        return "Overview";
    }


    @PostMapping("/after-new-ChatServer")
    public static String newChatServer(@ModelAttribute("chatserver") ChatServer newChatServer, Model model, HttpSession session) throws SQLException {
        model.addAttribute("ChatServer", ServerOverview.ChatServer_list);
        User user = (User) session.getAttribute("user");
        SQL.newChatServer(newChatServer, SQL.getUserIdByUsername(user.username));
        model.addAttribute("ChatServer", ServerOverview.getChatServerIntoList());
        return "Overview";
    }
}
