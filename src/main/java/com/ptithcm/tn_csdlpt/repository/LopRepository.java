/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.ptithcm.tn_csdlpt.entity.Lop;
import com.ptithcm.tn_csdlpt.entity.MonHoc;
import com.ptithcm.tn_csdlpt.entity.SinhVien;
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
public class LopRepository {

    public List<Object> findAll() throws SQLException {
        String sql = "SELECT * FROM LOP";

        try (Connection cnn = LoginVariables.databaseConnector.getConnection(); Statement stmt = cnn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            List<Object> lop = new ArrayList<>();
            while (rs.next()) {
                lop.add(
                        new Lop(
                                rs.getString(1), rs.getString(2),
                                rs.getString(3)
                        )
                );
            }
            return lop;
        }
    }

    //HÀM NÀY DÙNG ĐỂ LẤY TOÀN BỘ LỚP THEO KHOA
    public List<Object> findAllMAKH(String Makh) throws SQLException {
        String sql = "{call SP_LAYLOPTHEOKHOA(?)}";

        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1, Makh);
            ResultSet rs = cstm.executeQuery();

            List<Object> lops = new ArrayList<>();
            while (rs.next()) {
                lops.add(new Lop(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return lops;
        }
    }

    //hàm này dùng để lưu dữ liệu vào cơ sở dữ liệu
    public void saveAll(SQLServerDataTable sqlServerDataTable) throws SQLException {
        String sql = "{call SP_GHIDANHSACHLOP(?)}";

        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setObject(1, sqlServerDataTable);
            cstm.execute();
        }
    }

    //hàm này dùng để gọi sp kiểm tra xem giản viên có tồn tại hay chưa
    public static boolean checkMaLop(String magv) throws SQLException {
        String sql = "{call SP_CHECKMALOP(?)}";
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
