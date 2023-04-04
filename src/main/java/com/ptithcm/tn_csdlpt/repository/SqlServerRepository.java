/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.ptithcm.tn_csdlpt.configuration.DatabaseConnector;
import com.ptithcm.tn_csdlpt.model.dto.Subscriber;
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
public class SqlServerRepository implements SelectDataRepositoryInterface {
    private DatabaseConnector databaseConnector;

    public SqlServerRepository(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }
    
    public int getPort(String serverName) throws SQLException {
        String sqlPattern = """
                        SELECT 
                        	PORT = (SELECT value 
                        	FROM string_split((data_source), ',')
                        	ORDER BY (SELECT NULL)
                        	OFFSET 1 ROWS 
                        	FETCH NEXT 1 ROWS ONLY)
                        FROM sys.servers 
                        WHERE (SELECT value 
                        		FROM string_split((data_source), ',') 
                        		ORDER BY (SELECT NULL) 
                        		OFFSET 0 ROWS 
                        		FETCH NEXT 1 ROWS ONLY) = '%s'
                     """;
        String sql = String.format(sqlPattern, serverName);
        try ( Connection cnn = databaseConnector.getConnection();
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            int port = -1;
            while (rs.next()) {
                port = rs.getInt("PORT");
            }
            return port;
        }
    }

    @Override
    public List<Object> findAll() throws SQLException {
        String sql = "SELECT TENCS, TENSERVER, DATABASENAME FROM V_DS_PHANMANH";
        
        try (Connection cnn = databaseConnector.getConnection();
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            List<Object> subscribers = new ArrayList<>();
            while (rs.next()) {
                subscribers.add(
                        new Subscriber(
                                rs.getString("TENCS"),
                                rs.getString("TENSERVER"),
                                getPort(rs.getString("TENSERVER")),
                                rs.getString("DATABASENAME")
                        )
                );
            }
            return subscribers;
        }
    }
    
    @Override
    public Object find() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
