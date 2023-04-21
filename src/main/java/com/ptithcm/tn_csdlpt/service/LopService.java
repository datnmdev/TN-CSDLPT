/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.ptithcm.tn_csdlpt.entity.GiaoVien;
import com.ptithcm.tn_csdlpt.entity.Lop;
import com.ptithcm.tn_csdlpt.model.dto.ObjectAction;
import com.ptithcm.tn_csdlpt.repository.GiaoVienRepository;
import com.ptithcm.tn_csdlpt.repository.KhoaRepository;
import com.ptithcm.tn_csdlpt.repository.LopRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class LopService {
    
     //hàm này dùng để lấy toàn bộ giáo viên
    public List<Lop> getAllLop() throws SQLException {
        return  toLops(new LopRepository().findAll());
    }
    
    public List<Lop> toLops(List<Object> objects) {
        List<Lop> lops = new ArrayList<>();
        objects.forEach(object -> lops.add((Lop) object));
        return lops;
    }
    
    //hàm này dùng để kết nối 
     public static void saveAll(List<ObjectAction> objectActions) throws SQLException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        SQLServerDataTable sqlServerDataTable = SQLConvert.toT_LOP(Filter.getChangedObjectActions(objectActions));
        LopRepository lopRepository = new LopRepository();
        lopRepository.saveAll(sqlServerDataTable);
    }
}
