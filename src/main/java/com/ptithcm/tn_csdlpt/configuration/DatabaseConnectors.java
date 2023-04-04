/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.configuration;

import com.ptithcm.tn_csdlpt.model.dto.Account;
import com.ptithcm.tn_csdlpt.model.dto.DatabaseInformation;
import com.ptithcm.tn_csdlpt.view.ExceptionMessageBox;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author MINHDAT
 */

public class DatabaseConnectors {
    public static DatabaseConnector databasePubConnector;
    public static Map<String,DatabaseConnector> databaseSubConnectors = null;
    
    static {
        try {
            InputStream input = DatabaseConnectors.class.getClassLoader().getResourceAsStream("config-files/config-main-side.properties");
            Properties prop = new Properties();
            prop.load(input);
            databasePubConnector = new DatabaseConnector(
                    new DatabaseInformation(
                            prop.getProperty("serverName"), 
                            Integer.parseInt(prop.getProperty("port")), 
                            prop.getProperty("databaseName")
                    ),
                    new Account(prop.getProperty("username"), prop.getProperty("password"))
            );
        } catch (IOException ex) {
            ExceptionMessageBox.showErrorBox(ex.getClass().getName(), ex.getMessage());
        }
    }
}
