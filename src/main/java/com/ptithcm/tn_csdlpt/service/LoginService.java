/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.ptithcm.tn_csdlpt.configuration.DatabaseConnector;
import com.ptithcm.tn_csdlpt.exception.InvalidInputException;
import com.ptithcm.tn_csdlpt.global_variable.LoginVariables;
import com.ptithcm.tn_csdlpt.model.dto.Account;
import com.ptithcm.tn_csdlpt.repository.LoginRepository;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author MINHDAT
 */
public class LoginService {
    private DatabaseConnector databaseConnector;

    public LoginService(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }
    
    public void login(Account account) throws SQLException, IOException, InvalidInputException {
        Properties prop = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config-files/config-student-account.properties");) {
            prop.load(inputStream);
            if (account.getObject().equals("Sinh viên")) {
                databaseConnector.setDataSource(prop.getProperty("loginName"), prop.getProperty("password"));
                if (!(new LoginRepository(databaseConnector).getLoginResult(account))) {
                    throw new InvalidInputException("Tên đăng nhập hoặc mật khẩu không đúng!");
                }
            } else {
                databaseConnector.setDataSource(account);
            }
        }
        
        try (Connection conn = databaseConnector.getConnection();) {
            new LoginRepository(databaseConnector).getUserInfo(account);
            databaseConnector.setAccount(account);
        }
        
//        Gán thông tin đăng nhập và kết nối vào biến toàn cục
        LoginVariables.databaseConnector = databaseConnector;
    }
}
