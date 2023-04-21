/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.ptithcm.tn_csdlpt.entity.SinhVien;
import com.ptithcm.tn_csdlpt.global_variable.LoginVariables;
import com.ptithcm.tn_csdlpt.model.dto.GiaoVienDto;
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
public class SinhVienRepository {
    
    //hàm này dùng để lấy dữ liệu về
    public List<Object> findAll() throws SQLException {
        String sql = "SELECT * FROM SINHVIEN";

        try (Connection cnn = LoginVariables.databaseConnector.getConnection(); Statement stmt = cnn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            List<Object> students = new ArrayList<>();
            while (rs.next()) {
                students.add(
                        new SinhVien(
                                rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getDate(4),
                                rs.getString(5), rs.getString(6)
                        )
                );
            }
            return students;
        }
    }
    
    //hàm này dùng để lưu dữ liệu vào cơ sở dữ liệu
    public void saveAll(SQLServerDataTable sqlServerDataTable) throws SQLException {
        String sql = "{call SP_GHIDANHSACHSINHVIEN(?)}";
        
        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setObject(1, sqlServerDataTable);
            cstm.execute();
        }
    }
    
     //hàm này dùng để gọi sp kiểm tra xem giản viên có tồn tại hay chưa
    public static boolean checkMaSV(String magv) throws SQLException {
        String sql = "{call SP_CHECKMASINHVIEN(?)}";
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
