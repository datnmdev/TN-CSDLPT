/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.entity;

import java.util.Date;

/**
 *
 * @author MINHDAT
 */
public class GiaoVienDangKy {
    private String maGV;
    private String maMH;
    private String maLop;
    private String trinhDo;
    private Date ngayThi;
    private short lan;
    private short soCauThi;
    private short thoiGian;
    
//    Constructors
    public GiaoVienDangKy() {
    }

    public GiaoVienDangKy(String maGV, String maMH, String maLop, String trinhDo, Date ngayThi, short lan, short soCauThi, short thoiGian) {
        this.maGV = maGV;
        this.maMH = maMH;
        this.maLop = maLop;
        this.trinhDo = trinhDo;
        this.ngayThi = ngayThi;
        this.lan = lan;
        this.soCauThi = soCauThi;
        this.thoiGian = thoiGian;
    }
    
//    Getters and setters
    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public Date getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    public short getLan() {
        return lan;
    }

    public void setLan(short lan) {
        this.lan = lan;
    }

    public short getSoCauThi() {
        return soCauThi;
    }

    public void setSoCauThi(short soCauThi) {
        this.soCauThi = soCauThi;
    }

    public short getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(short thoiGian) {
        this.thoiGian = thoiGian;
    }
}
