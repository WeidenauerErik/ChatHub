package chathub;

import java.util.Objects;

public class ChatServer {
    String server_id;
    String name;
    String description;
    String shorty;
    String password;
    String admin_id;

    public ChatServer(String server_id, String name, String description, String shorty, String password, String admin_id) {
        this.server_id = server_id;
        this.name = name;
        this.description = description;
        this.shorty = shorty;
        this.password = password;
        this.admin_id = admin_id;
    }

    @Override
    public String toString() {
        return "ChatServer{" +
                "server_id='" + server_id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", shorty='" + shorty + '\'' +
                ", password='" + password + '\'' +
                ", admin_id='" + admin_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatServer that = (ChatServer) o;
        return Objects.equals(server_id, that.server_id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(shorty, that.shorty) && Objects.equals(password, that.password) && Objects.equals(admin_id, that.admin_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(server_id, name, description, shorty, password, admin_id);
    }

    public String getServer_id() {
        return server_id;
    }

    public void setServer_id(String server_id) {
        this.server_id = server_id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
}
