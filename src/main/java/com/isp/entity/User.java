package com.isp.entity;

/**
 * @author Geminit
 * @create 2016-9-11
 */

public class User {

    private Long id;
    private String account;
    private String username;
    private Integer role;
    private Integer status;
    private String email;

    private Role rolee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRolee() {
        return rolee;
    }

    public void setRolee(Role rolee) {
        this.rolee = rolee;
    }
}
