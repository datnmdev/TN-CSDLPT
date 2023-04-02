/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.ptithcm.tn_csdlpt.configuration.DatabaseConnectors;
import com.ptithcm.tn_csdlpt.global_variable.SubscribersVariables;
import com.ptithcm.tn_csdlpt.model.dto.Subscriber;
import com.ptithcm.tn_csdlpt.repository.SqlServerRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINHDAT
 */

public class SubscriberService {
    public List<Subscriber> findAllSubscribers() throws SQLException {
        return toSubscribers(new SqlServerRepository(DatabaseConnectors.databasePubConnector).findAll());
    }
    
    public void saveSubscribers(List<Subscriber> subscribers) {
        SubscribersVariables.subscribers = subscribers;
    }
    
    public List<Subscriber> getActiveSubcribers(List<Subscriber> subscribers) throws IOException {
        List<Subscriber> copiedSubscribers = new ArrayList<>();
        copiedSubscribers.addAll(subscribers);
        
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config-files/ignore-subscribers");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {
            
            List<String> ignoreServers = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ignoreServers.add(line);
            }
            
            ignoreServers.forEach(ignoreServer -> {
                copiedSubscribers.removeIf(subscriber -> subscriber.getServerName().equals(ignoreServer));
            });
        }
        return copiedSubscribers;
    }
    
    public List<Subscriber> toSubscribers(List<Object> objects) {
        List<Subscriber> subscribers = new ArrayList<>();
        
        for (Object object : objects) {
            subscribers.add((Subscriber) object);
        }
        return subscribers;
    }
}
