/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.ptithcm.tn_csdlpt.model.dto.ObjectAction;
import com.ptithcm.tn_csdlpt.repository.GiaoVienRepository;
import com.ptithcm.tn_csdlpt.repository.SinhVienRepository;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HP
 */
public class SinhVienService {
    //hàm này lấy toàn bộ dữ liệu code by hai mai

    public List<Object> getAllSinhVien() throws SQLException {
        return new SinhVienRepository().findAll();
    }
    
    
    //hàm này dùng để kết nối 
     public static void saveAll(List<ObjectAction> objectActions) throws SQLException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        SQLServerDataTable sqlServerDataTable = SQLConvert.toT_SINHVIEN(Filter.getChangedObjectActions(objectActions));
        SinhVienRepository sinhVienVienRepository = new SinhVienRepository();
        sinhVienVienRepository.saveAll(sqlServerDataTable);
    }
}
