package chathub;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.NoSuchAlgorithmException;

@Controller
public class Chat {

    @PostMapping("/after-server-click")
    public static String joining_server(@ModelAttribute("server_id") String server_id, @ModelAttribute("password") String password, Model model) throws NoSuchAlgorithmException {
        System.out.println("server_id = " + server_id);
        System.out.println("password = " + password);

        for (ChatServer tmp : ServerOverview.ChatServer_list) {
            if (tmp.server_id == server_id && tmp.password == PasswordEncryptor.encrypt(password)) {
                return "Chat";
            }
        }
        model.addAttribute("ChatServer",ServerOverview.ChatServer_list);
        model.addAttribute("wrong_password", "This was the wrong password!");
        return "Overview";
    }

}
