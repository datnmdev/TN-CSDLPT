/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.ptithcm.tn_csdlpt.entity.Khoa;
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
 * @author HP
 */
public class KhoaRepository {
    
    public static List<Khoa> findAll() throws SQLException {
        
        String sql = "SELECT * FROM KHOA";
        
        try (Connection cnn = LoginVariables.databaseConnector.getConnection();
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {
            
            List<Khoa> khoa = new ArrayList<>();
            while (rs.next()) {
                khoa.add(new Khoa(rs.getString(1), rs.getString(2) , rs.getString(3)));
            }
            return khoa;
        }
    }
    
    public List<Object> findAllOb() throws SQLException {
        String sql = "SELECT * FROM KHOA";

        try (Connection cnn = LoginVariables.databaseConnector.getConnection(); Statement stmt = cnn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            List<Object> khoa = new ArrayList<>();
            while (rs.next()) {
                khoa.add(
                        new Khoa(
                                rs.getString(1), rs.getString(2),
                                rs.getString(3)
                        )
                );
            }
            return khoa;
        }
    }
    
    //hàm này dùng để lưu dữ liệu vào cơ sở dữ liệu
    public void saveAll(SQLServerDataTable sqlServerDataTable) throws SQLException {
        String sql = "{call SP_GHIDANHSACHKHOA(?)}";
        
        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setObject(1, sqlServerDataTable);
            cstm.execute();
        }
    }
    
     //hàm này dùng để gọi sp kiểm tra xem giản viên có tồn tại hay chưa
    public static boolean checkMaKhoa(String magv) throws SQLException {
        String sql = "{call SP_CHECKMAKHOA(?)}";
        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setObject(1, magv);
            ResultSet rs = cstm.executeQuery();
            if (rs.next()) {
                int result = rs.getInt(1);
                return result == 1;
            }
        }
        return false;
    }

}
