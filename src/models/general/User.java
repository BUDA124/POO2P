package models.general;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String username;
    private String role;
    private String company;
    private String contactInfo;
    private String password;

    public User(String name, String username, String role, String company, String contactInfo, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.username = username;
        this.role = role;
        this.company = company;
        this.contactInfo = contactInfo;
        this.password = password;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // Métodos para manejar la contraseña de forma segura
    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", company='" + company + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}