/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.model.dto;

/**
 *
 * @author MINHDAT
 */
public class DatabaseInformation {
    private String serverName;
    private int port;
    private String databaseName;

    public DatabaseInformation() {
    }

    public DatabaseInformation(String serverName, int port, String databaseName) {
        this.serverName = serverName;
        this.port = port;
        this.databaseName = databaseName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

}
