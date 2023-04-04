/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.model.dto;

/**
 *
 * @author MINHDAT
 */
public class Account {
    private Subscriber subscriber;
    private String loginName;
    private String password;
    private String object;
    private String username;
    private String fullName;
    private String groupName;

//    Constructor
    public Account() {
    }
    
    public Account(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }
    
    public Account(Subscriber subscriber, String object, String loginName, String password) {
        this.subscriber = subscriber;
        this.object = object;
        this.loginName = loginName;
        this.password = password;
    }

    public Account(Subscriber subscriber, String loginName, String password, String object, String username, String fullName, String groupName) {
        this.subscriber = subscriber;
        this.loginName = loginName;
        this.password = password;
        this.object = object;
        this.username = username;
        this.fullName = fullName;
        this.groupName = groupName;
    }
    
//    Getters and setters
    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
