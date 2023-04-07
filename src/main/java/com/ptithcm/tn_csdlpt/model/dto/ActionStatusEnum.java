/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.ptithcm.tn_csdlpt.model.dto;

/**
 *
 * @author MINHDAT
 */
public enum ActionStatusEnum {
    INSERT("INSERT"), UPDATE("UPDATE"), DELETE("DELETE"), NO_ACTION("NO_ACTION");
    
    private String status;

    private ActionStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
