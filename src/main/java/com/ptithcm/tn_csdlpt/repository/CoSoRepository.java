/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.ptithcm.tn_csdlpt.entity.Khoa;
import com.ptithcm.tn_csdlpt.entity.MonHoc;
import com.ptithcm.tn_csdlpt.global_variable.LoginVariables;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class CoSoRepository {
    
    public static String findMacs() throws SQLException {
        
        String sql = "SELECT MACS FROM COSO";
        
        try (Connection cnn = LoginVariables.databaseConnector.getConnection();
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            String macs = null;
            while (rs.next()) {
                macs = rs.getString(1);
            }
            return macs;
        }
    }
    
    
}
