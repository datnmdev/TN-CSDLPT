/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.ptithcm.tn_csdlpt.entity.BoDe;
import com.ptithcm.tn_csdlpt.global_variable.LoginVariables;
import java.sql.Array;
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
public class BoDeRepository implements SelectDataRepositoryInterface, SaveDataRepositoryInterface {

    @Override
    public Object find(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Object find() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> findAll() throws SQLException {
        String sql = "{call SP_LAYDANHSACHCAUHOI(?,?)}";
        
        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1, LoginVariables.databaseConnector.getAccount().getGroupName());
            cstm.setString(2, LoginVariables.databaseConnector.getAccount().getUsername());
            ResultSet rs = cstm.executeQuery();
            
            List<Object> questions = new ArrayList<>();
            while (rs.next()) {
                questions.add(
                        new BoDe(
                                rs.getInt(1), rs.getString(2), 
                                rs.getString(3), rs.getString(4), 
                                rs.getString(5), rs.getString(6), 
                                rs.getString(7), rs.getString(8), 
                                rs.getString(9), rs.getString(10)
                        )
                );
            }
            return questions;
        }
    }

    @Override
    public void saveAll(SQLServerDataTable sqlServerDataTable) throws SQLException {
        String sql = "{call SP_GHIDANHSACHCAUHOI(?)}";
        
        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setObject(1, sqlServerDataTable);
            cstm.execute();
        }
    }
    
    public List<String> getLevelList() throws SQLException {
        String sql = "SELECT * FROM V_DS_TRINHDO";
        
        try (Connection cnn = LoginVariables.databaseConnector.getConnection();
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            List<String> levelList = new ArrayList<>();
            while (rs.next()) {
                levelList.add(rs.getString(1));
            }
            return levelList;
        }
    }
}
