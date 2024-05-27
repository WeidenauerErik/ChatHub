package chathub;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

public class NewChatServer {

    @PostMapping("back-to-overview")
    public static String back_to_overview() {
        return "Overview";
    }

    @PostMapping("/after-new-ChatServer")
    public static String newChatServer(Model model, @ModelAttribute("ChatServer") ChatServer newChatServer) throws SQLException {
        System.out.println("model.getAttribute(\"user\") = " + model.getAttribute("user"));
        System.out.println("newChatServer = " + newChatServer);
        SQL.newChatServer(newChatServer, (String) model.getAttribute("user"));
        model.addAttribute("ChatServer", ServerOverview.getChatServerIntoList());
        return "Overview";
    }
}
