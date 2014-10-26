package com.stairways.model;

import java.io.Serializable;

/**
 * Created by matvey on 14.10.14.
 */
public class User implements Serializable {


    private int idUser;
    private String email;
    private String username;
    private String passHash;
    private String passSalt;
    private int roleId;

    public User() {

    }


    @Override
    public String toString() {
        return username;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getPassSalt() {
        return passSalt;
    }

    public void setPassSalt(String passSalt) {
        this.passSalt = passSalt;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}