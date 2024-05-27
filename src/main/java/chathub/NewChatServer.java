package chathub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
@Controller
public class NewChatServer {

    public static User user;

    @PostMapping("/after-new-ChatServer-btn")
    public static String newChatServerbtn(@ModelAttribute("user") User newuser, Model model) {
        user = newuser;
        System.out.println(user);
        return "NewChatServer";
    }

    @PostMapping("back-to-overview")
    public static String back_to_overview(Model model) {
        model.addAttribute("ChatServer", ServerOverview.ChatServer_list);
        return "Overview";
    }


    @PostMapping("/after-new-ChatServer")
    public static String newChatServer(@ModelAttribute("chatserver") ChatServer newChatServer, Model model) throws SQLException {
        model.addAttribute("ChatServer", ServerOverview.ChatServer_list);
        System.out.println(user);

        SQL.newChatServer(newChatServer, SQL.getUserIdByFirstname(user.username));
        model.addAttribute("ChatServer", ServerOverview.getChatServerIntoList());
        return "Overview";
    }
}
