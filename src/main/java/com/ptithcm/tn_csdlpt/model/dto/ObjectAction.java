/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.model.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINHDAT
 */
public class ObjectAction {
    private List<ActionStatusEnum> status;
    private int listIndex;
    private int tableIndex;
    private List<Object> objects;

//    Constructors
    public ObjectAction(int listIndex, Object object) {
        this.status = new ArrayList<>();
        this.status.add(ActionStatusEnum.NO_ACTION);
        this.listIndex = listIndex;
        this.objects = new ArrayList<>();
        this.objects.add(object);
    }

    public ObjectAction(ActionStatusEnum status, int tableIndex, Object object) {
        this.status = new ArrayList<>();
        this.status.add(status);
        this.tableIndex = tableIndex;
        this.objects = new ArrayList<>();
        this.objects.add(object);
    }

    public ObjectAction(ActionStatusEnum status, int listIndex, int tableIndex, Object object) {
        this.status = new ArrayList<>();
        this.status.add(status);
        this.listIndex = listIndex;
        this.tableIndex = tableIndex;
        this.objects = new ArrayList<>();
        this.objects.add(object);
    }

    public ObjectAction(ObjectAction objectAction) {
        this.status = new ArrayList<>();
        this.status.add(objectAction.getStatus().get(0));
        this.listIndex = objectAction.listIndex;
        this.tableIndex = objectAction.tableIndex;
        this.objects = new ArrayList<>();
        this.objects.addAll(objectAction.getObjects());
    }
    
    public String getSQLAction() {
        String action;
        if (status.get(0).equals(ActionStatusEnum.NO_ACTION)) {
            ActionStatusEnum lastStatus = status.get(status.size()-1);
            switch (lastStatus) {
                case NO_ACTION:
                case INSERT:
                    action = ActionStatusEnum.NO_ACTION.getName();
                    break;
                default:
                    action = lastStatus.getName();
            }
        } else {
            if(status.get(status.size()-1) != ActionStatusEnum.DELETE ){
                 action = ActionStatusEnum.INSERT.getName();
            }else{
                action = ActionStatusEnum.NO_ACTION.getName();
            }
        }
        return action;
    }
    
//    Getters and setters
    public List<ActionStatusEnum> getStatus() {
        return status;
    }

    public void setStatus(List<ActionStatusEnum> status) {
        this.status = status;
    }

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

    public int getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(int tableIndex) {
        this.tableIndex = tableIndex;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }
}
