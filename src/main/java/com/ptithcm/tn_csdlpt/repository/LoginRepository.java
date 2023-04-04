/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.ptithcm.tn_csdlpt.configuration.DatabaseConnector;
import com.ptithcm.tn_csdlpt.model.dto.Account;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MINHDAT
 */
public class LoginRepository {
    private DatabaseConnector databaseConnector;

    public LoginRepository(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }
    
    public Boolean getLoginResult(Account account) throws SQLException {
        String sql = "{call SP_CHECK_LOGIN_SV(?, ?, ?)}";
        
        try (Connection connection = databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1, account.getLoginName());
            cstm.setString(2, account.getPassword());
            cstm.registerOutParameter(3, java.sql.Types.BOOLEAN);
            cstm.execute();
            return cstm.getBoolean(3);
        }
    }
    
    public void getUserInfo(Account account) throws SQLException {
        String sql = "{call SP_GET_USER_INFO(?, ?)}";
        
        try (Connection connection = databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1, account.getLoginName());
            cstm.setString(2, account.getObject());
            ResultSet rs = cstm.executeQuery();
            
            while (rs.next()) {
                account.setUsername(rs.getString(1));
                account.setFullName(rs.getString(2));
                account.setGroupName(rs.getString(3));
            }
        }
    }
}
