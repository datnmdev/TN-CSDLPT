/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.entity;

/**
 *
 * @author MINHDAT
 */
public class Khoa {
    private String maKH;
    private String tenKH;
    private String maCS;
    
//    Constructors
    public Khoa() {
    }

    public Khoa(String maKH, String tenKH, String maCS) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.maCS = maCS;
    }

//    Getters and setters
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaCS() {
        return maCS;
    }

    public void setMaCS(String maCS) {
        this.maCS = maCS;
    }
    
}
