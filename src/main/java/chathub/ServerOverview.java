package chathub;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Controller
public class ServerOverview {

    public static List<ChatServer> ChatServer_list;

    public static List<ChatServer> getChatServerIntoList() throws SQLException {
        ResultSet result = SQL.getAllServer();
        List<ChatServer> output = new ArrayList<>();
        while (result.next()) {
            output.add(new ChatServer(result.getString("server_id"), result.getString("name"), result.getString("description"), result.getString("shorty"), result.getString("password"), result.getString("admin_id")));
        }
        ChatServer_list = output;
        return output;
    }

    public static void showChatServer(Model model) throws SQLException {
        model.addAttribute("ChatServer", getChatServerIntoList());
    }

    @PostMapping("/after-search-method")
    public static String search(@ModelAttribute("input") String input, Model model) {
        Collections.sort(ChatServer_list, Comparator.comparingInt(s -> StringSearch.levenshteinDistance(input, s.name)));
        model.addAttribute("ChatServer", ChatServer_list);
        return "Overview";
    }

}
