/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.entity;

/**
 *
 * @author MINHDAT
 */
public class CoSo {
    private String maCS;
    private String tenCS;
    private String diaChi;

//    Constructors
    public CoSo() {
    }

    public CoSo(String maCS, String tenCS, String diaChi) {
        this.maCS = maCS;
        this.tenCS = tenCS;
        this.diaChi = diaChi;
    }

//    Getters and setters
    public String getMaCS() {
        return maCS;
    }

    public void setMaCS(String maCS) {
        this.maCS = maCS;
    }

    public String getTenCS() {
        return tenCS;
    }

    public void setTenCS(String tenCS) {
        this.tenCS = tenCS;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
   
}
