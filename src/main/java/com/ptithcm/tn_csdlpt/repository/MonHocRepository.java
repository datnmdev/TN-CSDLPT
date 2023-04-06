/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.ptithcm.tn_csdlpt.entity.MonHoc;
import com.ptithcm.tn_csdlpt.global_variable.LoginVariables;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINHDAT
 */
public class MonHocRepository implements SelectDataRepositoryInterface {
    @Override
    public Object find(Object object) throws SQLException {
        String sql = "{call SP_LAYTHONGTINMONHOC(?)}";
        
        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1, String.valueOf(object));
            ResultSet rs = cstm.executeQuery();
            
           Object subject = null;
            while (rs.next()) {
                subject = new MonHoc(rs.getString(1), rs.getString(2));
            }
            return subject;
        }
    }

    @Override
    public List<Object> findAll() throws SQLException {
        String sql = "SELECT * FROM MONHOC";
        
        try (Connection cnn = LoginVariables.databaseConnector.getConnection();
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            List<Object> subjects = new ArrayList<>();
            while (rs.next()) {
                subjects.add(new MonHoc(rs.getString(1), rs.getString(2)));
            }
            return subjects;
        }
    }
}
