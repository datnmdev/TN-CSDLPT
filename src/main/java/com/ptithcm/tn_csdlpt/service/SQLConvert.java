/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.ptithcm.tn_csdlpt.entity.BoDe;
import com.ptithcm.tn_csdlpt.model.dto.ObjectAction;
import java.util.List;

/**
 *
 * @author MINHDAT
 */
public class SQLConvert {
    public static SQLServerDataTable toT_CAUHOI(List<ObjectAction> objectActions) throws SQLServerException {
//        Định nghĩa bảng sẽ truyền vào SP
        SQLServerDataTable t_cauhoi = new SQLServerDataTable();
        t_cauhoi.addColumnMetadata("ACTION_NAME", java.sql.Types.NVARCHAR);
        t_cauhoi.addColumnMetadata("CAUHOI", java.sql.Types.INTEGER);
        t_cauhoi.addColumnMetadata("MAMH", java.sql.Types.NCHAR);
        t_cauhoi.addColumnMetadata("TRINHDO", java.sql.Types.NCHAR);
        t_cauhoi.addColumnMetadata("NOIDUNG", java.sql.Types.NVARCHAR);
        t_cauhoi.addColumnMetadata("A", java.sql.Types.NVARCHAR);
        t_cauhoi.addColumnMetadata("B", java.sql.Types.NVARCHAR);
        t_cauhoi.addColumnMetadata("C", java.sql.Types.NVARCHAR);
        t_cauhoi.addColumnMetadata("D", java.sql.Types.NVARCHAR);
        t_cauhoi.addColumnMetadata("DAP_AN", java.sql.Types.NCHAR);
        t_cauhoi.addColumnMetadata("MAGV", java.sql.Types.NCHAR);
        
//        Thêm dữ liệu vào bảng
        for (ObjectAction objectAction : objectActions) {
            BoDe question = (BoDe) objectAction.getObjects().get(0);
            t_cauhoi.addRow(
                    objectAction.getSQLAction(), question.getCauHoi(), 
                    question.getMaMH(), question.getTrinhDo(), question.getNoiDung(), 
                    question.getA(), question.getB(), question.getC(), 
                    question.getD(), question.getDapAn(), question.getMaGV()
            );
        }
        
//        Tạo ra mảng Array
        return t_cauhoi;
    }
}
