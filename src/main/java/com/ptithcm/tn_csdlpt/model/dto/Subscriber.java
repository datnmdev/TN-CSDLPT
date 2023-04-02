/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.model.dto;

/**
 *
 * @author MINHDAT
 */
public class Subscriber extends DatabaseInformation {
    private String tenCS; // The description of the local publications
    
//    Constructors
    public Subscriber(String tenCS, String serverName) {
        this.tenCS = tenCS;
        setServerName(serverName);
    }
    
    public Subscriber(String tenCS, String serverName, String databaseName) {
        this.tenCS = tenCS;
        setServerName(serverName);
        setDatabaseName(databaseName);
    }

    public Subscriber(String tenCS, String serverName, int port, String databaseName) {
        super(serverName, port, databaseName);
        this.tenCS = tenCS;
    }

//    Getters and setters
    public String getTenCS() {
        return tenCS;
    }

    public void setTenCS(String tenCS) {
        this.tenCS = tenCS;
    }
}
