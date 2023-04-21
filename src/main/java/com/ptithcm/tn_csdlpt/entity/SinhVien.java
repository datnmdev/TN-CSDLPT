/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MINHDAT
 */
public class SinhVien {

    private String maSV;
    private String ho;
    private String ten;
    private Date ngaySinh;
    private String diaChi;
    private String maLop;

//    Constructors
    public SinhVien() {
    }

    public SinhVien(String maSV, String ho, String ten, Date ngaySinh, String diaChi, String maLop) {
        this.maSV = maSV;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maLop = maLop;
    }

    public SinhVien(String maSV, String ho, String ten, String ngaySinhStr, String diaChi, String maLop) throws ParseException {
        this.maSV = maSV;
        this.ho = ho;
        this.ten = ten;
        this.diaChi = diaChi;
        this.maLop = maLop;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaySinh = dateFormat.parse(ngaySinhStr);
        this.ngaySinh = ngaySinh;
    }

//    Getters and setters
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getNgaySinhStr() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(ngaySinh);
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

}
