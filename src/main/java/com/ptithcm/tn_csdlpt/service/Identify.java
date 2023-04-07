/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.ptithcm.tn_csdlpt.entity.BoDe;
import com.ptithcm.tn_csdlpt.model.dto.ObjectAction;
import java.util.List;

/**
 *
 * @author MINHDAT
 */
public class Identify {
    public static int questionId(List<ObjectAction> objectActions) {
        int max = 0;
        for (ObjectAction objectAction : objectActions) {
            max = Math.max(max, ((BoDe) objectAction.getObjects().get(0)).getCauHoi());
        }
        return max + 1;
    }
}
