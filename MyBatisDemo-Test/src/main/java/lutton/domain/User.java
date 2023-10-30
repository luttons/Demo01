package com.lutton.domain;

/**
 * @ClassName：User
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class User {
    private int id;
    private String username;
    private String password;
    private String competence;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", competence='" + competence + '\'' +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public User(int id, String username, String password, String competence) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.competence = competence;
    }

    public User(String username, String password, String competence) {
        this.username = username;
        this.password = password;
        this.competence = competence;
    }
}
