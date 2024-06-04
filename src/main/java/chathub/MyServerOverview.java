package chathub;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static chathub.ServerOverview.getChatServerIntoList;

@Controller
public class MyServerOverview {
    public static List<ChatServer> ChatServer_list;

    public static void getChatServer(Model model, HttpSession session) throws SQLException {
        ResultSet result = SQL.getAllServer();
        List<ChatServer> output = new ArrayList<>();
        while (result.next()) {
            output.add(new ChatServer(result.getString("server_id"), result.getString("name"), result.getString("description"), result.getString("shorty"), result.getString("password"), result.getString("admin_id")));
        }
        User user = (User) session.getAttribute("user");
        if (SQL.getUserMy_chatserverByUsername(user.username) != null) {
            String[] my_chatserver = SQL.getUser_mychatserverByusername(user.username).split(",");
            List<ChatServer> solution = new ArrayList<>();
            for (ChatServer tmp1 : output) {
                for (String tmp2 : my_chatserver) {
                    if (tmp2.equals(tmp1.server_id)) solution.add(tmp1);
                }
            }
            ChatServer_list = solution;
            model.addAttribute("ChatServer", solution);
        }
    }

    @PostMapping("after-select-server")
    public static String select_Server(@ModelAttribute("server_id") String server_id, Model model, HttpSession session) throws SQLException {
        model.addAttribute("Chats", getChat_list_from_server_id(getChatIntoList(), server_id));
        getChatServer(model, session);
        model.addAttribute("chatroom_name", SQL.getServer_nameByServerId(server_id));
        session.setAttribute("last_server_id", server_id);
        model.addAttribute("last_server_id", server_id);
        CustomLogger.logCustomInfo("Ein Benutzer ist in einem Chat beigetreten!");

        User user = (User) session.getAttribute("user");
        return "MyChatServers";
    }

    @PostMapping("/after-server-click")
    public static String joining_server(@ModelAttribute("server_id") String server_id, @ModelAttribute("password") String password, Model model, HttpSession session) throws NoSuchAlgorithmException, SQLException {
        for (ChatServer tmp : ServerOverview.ChatServer_list) {
            if (tmp.server_id.equals(server_id) && tmp.password.equals(PasswordEncryptor.encrypt(password))) {
                CustomLogger.logCustomInfo("Ein Benutzer ist in einem Chat beigetreten!");
                addServer(session, server_id);
                getChatServer(model, session);
                session.setAttribute("last_server_id", server_id);
                return "MyChatServers_start";
            }
        }
        model.addAttribute("ChatServer", getChatServerIntoList());
        model.addAttribute("wrong_password", "This was the wrong password!");
        return "Overview";
    }

    public static void addServer(HttpSession session, String server_id) throws SQLException {
        User user = (User) session.getAttribute("user");
        String my_chatserver = SQL.getUserMy_chatserverByUsername(user.username);
        if (my_chatserver != null) {
            if (my_chatserver.length() > 0) {
                SQL.setmy_chatserver(user.username, my_chatserver + "," + server_id);

            }
        } else {
            SQL.setmy_chatserver(user.username, server_id);
        }

    }

    public static List<Chat> getChatIntoList() throws SQLException {
        ResultSet result = SQL.getAllChats();
        List<Chat> output = new ArrayList<>();
        String server_name = null;
        while (result.next()) {
            output.add(new Chat(result.getString("chat_id"), result.getString("message"), result.getString("owner"), result.getString("date"), result.getString("server_id"), server_name));
        }
        return output;
    }

    public static List<Chat> getChat_list_from_server_id(List<Chat> input, String server_id) throws SQLException {
        List<Chat> output = new ArrayList<>();

        for (Chat tmp1 : input) {
            if (tmp1.server_id.equals(server_id)) {
                List<ChatServer> chatserver = getChatServerIntoList();
                for (ChatServer tmp2 : chatserver) {
                    if (tmp2.server_id.equals(tmp1.server_id)) tmp1.setServer_name(tmp2.name);
                }
                output.add(tmp1);
            }
        }

        return output;
    }


    @PostMapping("after-add-chat")
    public static String after_add_chat(Model model, HttpSession session, @ModelAttribute("message") String message) throws SQLException {
        SQL.add_new_chat(message, ((User) session.getAttribute("user")).username, (String) session.getAttribute("last_server_id"));
        getChatServer(model, session);
        model.addAttribute("Chats", getChat_list_from_server_id(getChatIntoList(), (String) session.getAttribute("last_server_id")));
        CustomLogger.logCustomInfo("Ein Benutzer hat einen Chat hinzugefügt!");
        model.addAttribute("chatroom_name", SQL.getServer_nameByServerId((String) session.getAttribute("last_server_id")));
        return "MyChatServers";
    }

    @PostMapping("after-refresh")
    public static String after_refresh(Model model, HttpSession session) throws SQLException {
        model.addAttribute("Chats", getChat_list_from_server_id(getChatIntoList(), (String) session.getAttribute("last_server_id")));
        getChatServer(model, session);
        model.addAttribute("chatroom_name", SQL.getServer_nameByServerId((String) session.getAttribute("last_server_id")));
        CustomLogger.logCustomInfo("Ein Benutzer hat die Seite refreshed!");
        return "MyChatServers";
    }
}
