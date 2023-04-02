/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.configuration;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.ptithcm.tn_csdlpt.model.dto.Account;
import com.ptithcm.tn_csdlpt.model.dto.DatabaseInformation;
import java.sql.Connection;

/**
 *
 * @author MINHDAT
 */
public class DatabaseConnector {
    private SQLServerDataSource sqlServerDataSource;
    private DatabaseInformation databaseInformation;
    private Account account;

//    Constructors
    public DatabaseConnector() {
        sqlServerDataSource = new SQLServerDataSource();
    }
    
    public DatabaseConnector(DatabaseInformation databaseInformation) {
        sqlServerDataSource = new SQLServerDataSource();
        this.databaseInformation = databaseInformation;
        setDataSource(databaseInformation);
    }
    
    public DatabaseConnector(DatabaseInformation databaseInformation, Account account) {
        sqlServerDataSource = new SQLServerDataSource();
        this.databaseInformation = databaseInformation;
        this.account = account;
        setDataSource(databaseInformation, account);
    }
    
//    Methods
    public Connection getConnection() throws SQLServerException {
       return sqlServerDataSource.getConnection();
    }
    
    public Connection getConnection(String url) throws SQLServerException {
        sqlServerDataSource.setURL(url);
        return sqlServerDataSource.getConnection();
    }
    
    public void setDataSource(DatabaseInformation databaseInformation) {
        sqlServerDataSource.setServerName(databaseInformation.getServerName());
        sqlServerDataSource.setPortNumber(databaseInformation.getPort());
        sqlServerDataSource.setDatabaseName(databaseInformation.getDatabaseName());
        sqlServerDataSource.setEncrypt("false");
    }
    
     public void setDataSource(Account account) {
        sqlServerDataSource.setUser(account.getLoginName());
        sqlServerDataSource.setPassword(account.getPassword());
    }
     
    public void setDataSource(DatabaseInformation databaseInformation, Account account) {
        sqlServerDataSource.setServerName(databaseInformation.getServerName());
        sqlServerDataSource.setPortNumber(databaseInformation.getPort());
        sqlServerDataSource.setDatabaseName(databaseInformation.getDatabaseName());
        sqlServerDataSource.setUser(account.getLoginName());
        sqlServerDataSource.setPassword(account.getPassword());
        sqlServerDataSource.setEncrypt("false");
    }
    
//    Getters and setters
    public SQLServerDataSource getSqlServerDataSource() {
        return sqlServerDataSource;
    }

    public void setSqlServerDataSource(SQLServerDataSource sqlServerDataSource) {
        this.sqlServerDataSource = sqlServerDataSource;
    }

    public DatabaseInformation getDatabaseInformation() {
        return databaseInformation;
    }

    public void setDatabaseInformation(DatabaseInformation databaseInformation) {
        this.databaseInformation = databaseInformation;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
