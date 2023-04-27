/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.ptithcm.tn_csdlpt.global_variable.LoginVariables;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class CreateLoginRepository {

    //hàm này dùng để tạo login
    public static void createLogin(String LGName, String Pass, String UserName, String Role) throws SQLException {
        String sql = "{call SP_TAOLOGIN(?,?,?,?)}";

        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1, LGName);
            cstm.setString(2, Pass);
            cstm.setString(3, UserName);
            cstm.setString(4, Role);

            cstm.execute();

        }

    }

    //HÀM NÀY DÙNG ĐỂ TẠO LOGIN TRƯỜNG
    public static int createLoginTruong(String LGName, String Pass, String UserName, String Role) throws SQLException {
        String sql = "{? = call SP_TAOLOGINTRUONG(?,?,?,?)}";

        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.registerOutParameter(1, Types.INTEGER); // đăng ký giá trị trả về
            cstm.setString(2, LGName);
            cstm.setString(3, Pass);
            cstm.setString(4, UserName);
            cstm.setString(5, Role);

            cstm.execute();
            
            int returnValue = cstm.getInt(1); // lấy giá trị trả về
            
            return returnValue;
            

        }

    }

    
    //hàm này dùng để kiểm tra xem user
    public static int checkUserName(String UserName) throws SQLException {
        String sql = "{? = call SP_CHECK_USERNAME(?)}";

        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.registerOutParameter(1, Types.INTEGER);             // đăng ký giá trị trả về
            cstm.setString(2, UserName);

            cstm.execute();

            int returnValue = cstm.getInt(1); // lấy giá trị trả về
            return returnValue;

        }

    }

    //hàm này dùng để lấy tên login
    public static String findLogin(String magv) throws SQLException {

        String sql = "{call SP_LAYLOGINNAME(?)}";

        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1, magv);

            ResultSet rs = cstm.executeQuery();

            String re = "";
            while (rs.next()) {
                re = rs.getString(1);
            }

            return re;

        }

    }

    //hàm này dùng để xóa tài khoản
    public static void clearLogin(String LGName, String UserName) throws SQLException {
        String sql = "{call SP_XOALOGIN(?,?)}";

        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1, LGName);
            cstm.setString(2, UserName);

            cstm.execute();

        }

    }
    
    //hàm này dùng để xóa tài khoản
    public static void clearLoginTruong(String LGName, String UserName) throws SQLException {
        String sql = "{call SP_XOALOGINTRUONG(?,?)}";

        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1, LGName);
            cstm.setString(2, UserName);

            cstm.execute();

        }

    }


    //hàm này dùng để kiểm tra xem tài khoản được chọn thuộc nhóm quyền nào
    public static List<String> findAll() throws SQLException {
        String sql = "{call sp_helprolemember(?)}";

        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            cstm.setString(1, LoginVariables.databaseConnector.getAccount().getGroupName());
            ResultSet rs = cstm.executeQuery();
            
            List<String> stringList = new ArrayList<String>();

            while (rs.next()) {
                stringList.add(rs.getString(2).strip());

            }
            return stringList;
        }
    }
    
     //mục đích là xem giáo viên đã có tài khoản hay chưa
    public static List<String> findAll99() throws SQLException {
        String sql = "select name from sys.database_principals";

        try (Connection connection = LoginVariables.databaseConnector.getConnection();) {
            CallableStatement cstm = connection.prepareCall(sql);
            
            ResultSet rs = cstm.executeQuery();
            
            List<String> stringList = new ArrayList<String>();

            while (rs.next()) {
                stringList.add(rs.getString(1).strip());

            }
            return stringList;
        }
    }

}
