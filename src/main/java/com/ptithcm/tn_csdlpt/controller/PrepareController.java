/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.controller;

import com.ptithcm.tn_csdlpt.global_variable.SubscribersVariables;
import com.ptithcm.tn_csdlpt.service.DatabaseConnectorService;
import com.ptithcm.tn_csdlpt.service.SubscriberService;
import com.ptithcm.tn_csdlpt.view.ExceptionMessageBox;
import java.sql.SQLException;

/**
 *
 * @author MINHDAT
 */
public class PrepareController {
    public static void findAndSaveSubscriberInformation() {
        try {
//            Lấy và lưu thông tin của các side phân mảnh
            SubscriberService subscriberService = new SubscriberService();
            subscriberService.saveSubscribers(subscriberService.findAllSubscribers());
            
//            Tạo và lưu các thông tin kết nối của các server phân mảnh
            DatabaseConnectorService databaseConnectorService = new DatabaseConnectorService();
            databaseConnectorService.saveDatabaseSubscriberConnectors(
                    databaseConnectorService.createDatabaseSubscriberConnectors(SubscribersVariables.subscribers)
            );
        } catch (SQLException ex) {
            ExceptionMessageBox.showErrorBox(ex.getClass().getName(), ex.getMessage());
            System.exit(0);
        }
    }
}
