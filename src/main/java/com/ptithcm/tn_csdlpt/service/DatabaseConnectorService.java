/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.ptithcm.tn_csdlpt.configuration.DatabaseConnector;
import com.ptithcm.tn_csdlpt.configuration.DatabaseConnectors;
import com.ptithcm.tn_csdlpt.model.dto.DatabaseInformation;
import com.ptithcm.tn_csdlpt.model.dto.Subscriber;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MINHDAT
 */
public class DatabaseConnectorService {
    public Map<String, DatabaseConnector> createDatabaseSubscriberConnectors(List<Subscriber> subscribers) throws SQLException {
        Map<String, DatabaseConnector> databaseSubConnectors = new HashMap<>();
        
        for (Subscriber subscriber : subscribers) {
            databaseSubConnectors.put(
                    subscriber.getServerName(),
                    new DatabaseConnector(
                            new DatabaseInformation(
                                    subscriber.getServerName(), 
                                    subscriber.getPort(),
                                    subscriber.getDatabaseName()
                            )
                    )
            );
        }
        return databaseSubConnectors;
    }
    
    public void saveDatabaseSubscriberConnectors(Map<String, DatabaseConnector> databaseSubscriberConnectors) {
        DatabaseConnectors.databaseSubConnectors = databaseSubscriberConnectors;
    }
}
