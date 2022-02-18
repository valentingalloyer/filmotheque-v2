package fr.eni.bo;

import java.util.List;

public class Membre {

    private int id;
    private String username;
    private String mail;
    private String password;
    private boolean admin;

    public Membre() {
    }

    public Membre(int id, String username, String mail, String password, boolean admin) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.admin = admin;
    }

    public Membre(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return username + " (" + mail + (isAdmin() ? ", admin" : "") + ")";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
