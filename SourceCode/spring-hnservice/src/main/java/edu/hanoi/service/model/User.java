package edu.hanoi.service.model;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "HN_USER", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User {
    private String username;
    private String password;
    private String email;
    private int age;
    private int groupId;
    public User() {
    }

    public User(String username, String password, String email, int age, int groupId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.groupId = groupId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Id
    @Column(name = "username",unique = true,nullable = false)
    public String getUsername() {
        return username;
    }

    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    @Column(name = "age")
    public int getAge() {
        return age;
    }
    @Column(name = "groupId", nullable = false)
    public int getGroupId() {
        return groupId;
    }



    public void setUsername(String s) {
        this.username = s;
    }
}
