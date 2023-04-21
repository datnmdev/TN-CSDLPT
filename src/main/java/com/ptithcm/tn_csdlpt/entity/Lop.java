/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.entity;

/**
 *
 * @author MINHDAT
 */
public class Lop {
    private String maLop;
    private String tenLop;
    private String maKH;
    
//    Constructors
    public Lop() {
    }

    public Lop(String maLop, String tenLop, String maKH) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maKH = maKH;
    }
    
    
    
     public String toString() {
        return maLop + " - " + tenLop;
    }

//    Getters and setters
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    
}
