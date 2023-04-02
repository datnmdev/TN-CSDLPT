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
public class BangDiem {
    private String maSV;
    private String maMH;
    private short lan;
    private Date ngayThi;
    private float diem;
    
//    Constructors
    public BangDiem() {
    }

    public BangDiem(String maSV, String maMH, short lan, Date ngayThi, float diem) {
        this.maSV = maSV;
        this.maMH = maMH;
        this.lan = lan;
        this.ngayThi = ngayThi;
        this.diem = diem;
    }
    
//    Getters and setters
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public short getLan() {
        return lan;
    }

    public void setLan(short lan) {
        this.lan = lan;
    }

    public Date getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(Date ngayThi) {
        this.ngayThi = ngayThi;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
}
