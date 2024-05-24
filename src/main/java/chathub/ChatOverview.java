package chathub;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatOverview {

    public static List<Chat> Chat_list;

    @PostMapping("/after-server-click")
    public static String joining_server(@ModelAttribute("server_id") String server_id, @ModelAttribute("password") String password, Model model) throws NoSuchAlgorithmException, SQLException {
        for (ChatServer tmp : ServerOverview.ChatServer_list) {
            if (tmp.server_id == server_id && tmp.password == PasswordEncryptor.encrypt(password)) {
                List<Chat> get_chats_from_server_id = getChat_list_from_server_id(getChatIntoList(),server_id);
                model.addAttribute("Chats", get_chats_from_server_id);
                return "Chat";
            }
        }

        model.addAttribute("ChatServer",ServerOverview.ChatServer_list);
        model.addAttribute("wrong_password", "This was the wrong password!");
        return "Overview";
    }

    public static List<Chat> getChatIntoList() throws SQLException {
        ResultSet result = SQL.getAllChats();
        List<Chat> output = new ArrayList<>();
        while (result.next()) {
            output.add(new Chat(result.getString("chat_id"),result.getString("message"),result.getString("owner"),result.getString("date"),"server_id"));
        }
        Chat_list = output;
        return output;
    }

    public static List<Chat> getChat_list_from_server_id(List<Chat> input, String server_id) {
        List<Chat> output = new ArrayList<>();

        for (Chat tmp : input) {
            if (tmp.server_id.equals(server_id)) output.add(tmp);
        }

        return output;
    }

}
