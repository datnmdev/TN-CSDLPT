/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.ptithcm.tn_csdlpt.entity.GiaoVien;
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
                teacher
                        = new GiaoVien(
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

        try (Connection cnn = LoginVariables.databaseConnector.getConnection(); Statement stmt = cnn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

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

    //hàm này dùng để lấy toàn bộ giáo viên từ database by hải mai
    public static List<GiaoVienDto> getAllGiaoVien() {
        String sql = "SELECT * FROM GIAOVIEN";
        List<GiaoVienDto> listGV = new ArrayList<>();
        try {

            Connection cnn = LoginVariables.databaseConnector.getConnection();
            // crate statement
            Statement stmt = cnn.createStatement();
            // get data from table 
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                GiaoVienDto gv = new GiaoVienDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 0);
                //System.out.println(rs.getDate(4)+ "  " + rs.getString(1));
                listGV.add(gv);
            }
            // close connection
            stmt.close();
            rs.close();
            cnn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listGV;
    }

    //hàm này dùng lưu
    public void saveAll(SQLServerDataTable sqlServerDataTable) throws SQLException {
        String sql = "{call SP_GHIDANHSACHGIAOVIEN(?)}";

        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setObject(1, sqlServerDataTable);
            cstm.execute();
        }
    }

    //hàm này dùng để gọi sp kiểm tra xem giản viên có tồn tại hay chưa
    public static boolean checkMaGV(String magv) throws SQLException {
        String sql = "{call SP_CHECKMAGIAOVIEN(?)}";
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
