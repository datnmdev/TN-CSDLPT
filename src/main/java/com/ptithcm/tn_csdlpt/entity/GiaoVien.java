/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.entity;

/**
 *
 * @author MINHDAT
 */
public class GiaoVien {
    private String maGV;
    private String ho;
    private String ten;
    private String diaChi;
    private String maKH;
    
//    Constructors
    public GiaoVien() {
    }

    public GiaoVien(String maGV, String ho, String ten, String diaChi, String maKH) {
        this.maGV = maGV;
        this.ho = ho;
        this.ten = ten;
        this.diaChi = diaChi;
        this.maKH = maKH;
    }

    @Override
    public String toString() {
        return maGV + " - " + ho + " " + ten;
    }
    
//    Getters and setters
    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    
}
