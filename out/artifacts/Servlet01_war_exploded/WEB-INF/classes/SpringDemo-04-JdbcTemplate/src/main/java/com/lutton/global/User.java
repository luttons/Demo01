package com.lutton.global;

/**
 * @ClassName：User
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class User {
    private int id;
    private String username ;
    private String password ;
    private String competence ;   // 权限

    public User(int id, String username, String password, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.competence = status;
    }

    public User(String username, String password, String status) {
        this.username = username;
        this.password = password;
        this.competence = status;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
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

    public String getStatus() {
        return competence;
    }

    public void setStatus(String status) {
        this.competence = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + competence + '\'' +
                '}';
    }
}
