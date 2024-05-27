package chathub;

public class Chat {
    String chat_id;
    String message;
    String owner;
    String date;
    String server_id;
    String server_name;

    public Chat(String chat_id, String message, String owner, String date, String server_id, String server_name) {
        this.chat_id = chat_id;
        this.message = message;
        this.owner = owner;
        this.date = date;
        this.server_id = server_id;
        this.server_name = server_name;
    }

    public String getChat_id() {
        return chat_id;
    }

    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getServer_id() {
        return server_id;
    }

    public void setServer_id(String server_id) {
        this.server_id = server_id;
    }

    public String getServer_name() {
        return server_name;
    }

    public void setServer_name(String server_name) {
        this.server_name = server_name;
    }
}
