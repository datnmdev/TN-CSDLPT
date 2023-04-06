/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.ptithcm.tn_csdlpt.entity.GiaoVien;
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
public class GiaoVienRepository implements SelectDataRepositoryInterface {
    @Override
    public Object find(Object object) throws SQLException {
        String sql = "{call SP_LAYTHONGTINGIAOVIEN(?)}";
        
        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1, String.valueOf(object));
            ResultSet rs = cstm.executeQuery();
            
           Object teacher = null;
            while (rs.next()) {
                teacher = 
                        new GiaoVien(
                                rs.getString(1), rs.getString(2), 
                                rs.getString(3), rs.getString(4), 
                                rs.getString(5)
                        );
            }
            return teacher;
        }
    }

    @Override
    public List<Object> findAll() throws SQLException {
        String sql = "SELECT * FROM GIAOVIEN";
        
        try (Connection cnn = LoginVariables.databaseConnector.getConnection();
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            List<Object> teachers = new ArrayList<>();
            while (rs.next()) {
                teachers.add(
                        new GiaoVien(
                                rs.getString(1), rs.getString(2), 
                                rs.getString(3), rs.getString(4), 
                                rs.getString(5)
                        )
                );
            }
            return teachers;
        }
    }
}
