package chathub;

public class ChatServer {
    String name;
    String description;
    String shorty;
    String password;
    String admin_id;

    public ChatServer(String name, String description, String shorty, String password, String admin_id) {
        this.name = name;
        this.description = description;
        this.shorty = shorty;
        this.admin_id = admin_id;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShorty() {
        return shorty;
    }

    public void setShorty(String shorty) {
        this.shorty = shorty;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    @Override
    public String toString() {
        return "ChatServer{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", shorty='" + shorty + '\'' +
                ", password='" + password + '\'' +
                ", admin_id='" + admin_id + '\'' +
                '}';
    }
}
