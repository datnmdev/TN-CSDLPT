/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.model.dto;

/**
 *
 * @author HP
 */
public class GiaoVienDto {
    private String maGV;
    private String ho;
    private String ten;
    private String diaChi;
    private String maKH;
    private int status;

    public GiaoVienDto(String maGV, String ho, String ten, String diaChi, String maKH, int status) {
        this.maGV = maGV;
        this.ho = ho;
        this.ten = ten;
        this.diaChi = diaChi;
        this.maKH = maKH;
        this.status = status;
    }

    public GiaoVienDto() {
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    

   
}
