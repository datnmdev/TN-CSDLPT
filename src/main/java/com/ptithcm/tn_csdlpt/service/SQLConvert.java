/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.ptithcm.tn_csdlpt.entity.BoDe;
import com.ptithcm.tn_csdlpt.entity.GiaoVien;
import com.ptithcm.tn_csdlpt.entity.Khoa;
import com.ptithcm.tn_csdlpt.entity.Lop;
import com.ptithcm.tn_csdlpt.entity.MonHoc;
import com.ptithcm.tn_csdlpt.entity.SinhVien;
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

    // code by hải mai
    public static SQLServerDataTable toT_GIAOVIEN(List<ObjectAction> objectActions) throws SQLServerException {
//        Định nghĩa bảng sẽ truyền vào SP
        SQLServerDataTable t_giaovien = new SQLServerDataTable();
        t_giaovien.addColumnMetadata("ACTION_NAME", java.sql.Types.NVARCHAR);
        t_giaovien.addColumnMetadata("MAGV", java.sql.Types.NCHAR);
        t_giaovien.addColumnMetadata("HO", java.sql.Types.NVARCHAR);
        t_giaovien.addColumnMetadata("TEN", java.sql.Types.NVARCHAR);
        t_giaovien.addColumnMetadata("DIACHI", java.sql.Types.NVARCHAR);
        t_giaovien.addColumnMetadata("MAKH", java.sql.Types.NCHAR);

//        Thêm dữ liệu vào bảng
        for (ObjectAction objectAction : objectActions) {
            GiaoVien teacher = (GiaoVien) objectAction.getObjects().get(0);
            t_giaovien.addRow(
                    objectAction.getSQLAction(), teacher.getMaGV(), teacher.getHo(), teacher.getTen(),
                    teacher.getDiaChi(), teacher.getMaKH());
        }

//        Tạo ra mảng Array
        return t_giaovien;
    }

    //hàm này dùng để ghi dữ liệu vò sinh viên
    public static SQLServerDataTable toT_SINHVIEN(List<ObjectAction> objectActions) throws SQLServerException {
//        Định nghĩa bảng sẽ truyền vào SP
        SQLServerDataTable t_sinhvien = new SQLServerDataTable();
        t_sinhvien.addColumnMetadata("ACTION_NAME", java.sql.Types.NVARCHAR);
        t_sinhvien.addColumnMetadata("MASV", java.sql.Types.NCHAR);
        t_sinhvien.addColumnMetadata("HO", java.sql.Types.NVARCHAR);
        t_sinhvien.addColumnMetadata("TEN", java.sql.Types.NVARCHAR);
        t_sinhvien.addColumnMetadata("NGAYSINH", java.sql.Types.DATE);
        t_sinhvien.addColumnMetadata("DIACHI", java.sql.Types.NVARCHAR);
        t_sinhvien.addColumnMetadata("MALOP", java.sql.Types.NCHAR);

//        Thêm dữ liệu vào bảng
        for (ObjectAction objectAction : objectActions) {
            SinhVien student = (SinhVien) objectAction.getObjects().get(0);
            java.util.Date ngaySinh = student.getNgaySinh();
            java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());
            t_sinhvien.addRow(
                    objectAction.getSQLAction(), student.getMaSV(), student.getHo(), student.getTen(), sqlNgaySinh,
                    student.getDiaChi(), student.getMaLop());
        }
        return t_sinhvien;
    }

    public static SQLServerDataTable toT_MONHOC(List<ObjectAction> objectActions) throws SQLServerException {
//        Định nghĩa bảng sẽ truyền vào SP
        SQLServerDataTable t_monhoc = new SQLServerDataTable();
        t_monhoc.addColumnMetadata("ACTION_NAME", java.sql.Types.NVARCHAR);
        t_monhoc.addColumnMetadata("MAGV", java.sql.Types.NCHAR);
        t_monhoc.addColumnMetadata("HO", java.sql.Types.NVARCHAR);

//        Thêm dữ liệu vào bảng
        for (ObjectAction objectAction : objectActions) {
            MonHoc monhoc = (MonHoc) objectAction.getObjects().get(0);
            t_monhoc.addRow(
                    objectAction.getSQLAction(), monhoc.getMaMH(), monhoc.getTenMH());
        }

//        Tạo ra mảng Array
        return t_monhoc;
    }

    public static SQLServerDataTable toT_KHOA(List<ObjectAction> objectActions) throws SQLServerException {
//        Định nghĩa bảng sẽ truyền vào SP
        SQLServerDataTable t_khoa = new SQLServerDataTable();
        t_khoa.addColumnMetadata("ACTION_NAME", java.sql.Types.NVARCHAR);
        t_khoa.addColumnMetadata("MAKH", java.sql.Types.NCHAR);
        t_khoa.addColumnMetadata("TENKH", java.sql.Types.NVARCHAR);
        t_khoa.addColumnMetadata("MACS", java.sql.Types.NVARCHAR);

//        Thêm dữ liệu vào bảng
        for (ObjectAction objectAction : objectActions) {
            Khoa k = (Khoa) objectAction.getObjects().get(0);
            t_khoa.addRow(
                    objectAction.getSQLAction(), k.getMaKH(), k.getTenKH(), k.getMaCS());
        }

//        Tạo ra mảng Array
        return t_khoa;
    }
    
     public static SQLServerDataTable toT_LOP(List<ObjectAction> objectActions) throws SQLServerException {
//        Định nghĩa bảng sẽ truyền vào SP
        SQLServerDataTable t_lop = new SQLServerDataTable();
        t_lop.addColumnMetadata("ACTION_NAME", java.sql.Types.NVARCHAR);
        t_lop.addColumnMetadata("MALOP", java.sql.Types.NCHAR);
        t_lop.addColumnMetadata("TENLOP", java.sql.Types.NVARCHAR);
        t_lop.addColumnMetadata("MAKH", java.sql.Types.NCHAR);

//        Thêm dữ liệu vào bảng
        for (ObjectAction objectAction : objectActions) {
            Lop k = (Lop) objectAction.getObjects().get(0);
            t_lop.addRow(
                    objectAction.getSQLAction(), k.getMaLop(), k.getTenLop(), k.getMaKH());
        }

//        Tạo ra mảng Array
        return t_lop;
    }

}
