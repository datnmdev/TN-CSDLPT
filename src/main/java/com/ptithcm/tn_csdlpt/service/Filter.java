/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.ptithcm.tn_csdlpt.model.dto.ActionStatusEnum;
import com.ptithcm.tn_csdlpt.model.dto.ObjectAction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINHDAT
 */
public class Filter {
    public static List<ObjectAction> getChangedObjectActions(List<ObjectAction> objectActions) {
        List<ObjectAction> changedObjectActions = new ArrayList<>();
        objectActions.forEach(objectAction -> {
            if (!objectAction.getSQLAction().equals(ActionStatusEnum.NO_ACTION.getName())) {
                changedObjectActions.add(objectAction);
            }
        });
        return changedObjectActions;
    }
}
