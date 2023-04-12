/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.ptithcm.tn_csdlpt.model.dto.ActionStatusEnum;
import com.ptithcm.tn_csdlpt.model.dto.ObjectAction;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author MINHDAT
 */
public class UndoRedo {
    private Stack<ObjectAction> undoStack;
    private Stack<ObjectAction> redoStack;

//    Constructors
    public UndoRedo() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }
    
//    Methods
    public void execute(ObjectAction objectAction, List<ObjectAction> objectActions) {
        switch (objectAction.getStatus().get(0)) {
            case INSERT:
                objectAction.getStatus().set(0, ActionStatusEnum.DELETE);
                break;
            case UPDATE:
                objectAction.getObjects().add(
                        objectActions.get(objectAction.getListIndex()).getObjects().get(0)
                );
                break;
            case DELETE:
                objectAction.getStatus().set(0, ActionStatusEnum.INSERT);
                break;
        }
        undoStack.push(objectAction);
        redoStack.clear();
    }
    
    public ObjectAction undo() {
        if (!undoStack.isEmpty()) {
            ObjectAction objectAction = undoStack.pop();
            ObjectAction copiedObjectAction = new ObjectAction(objectAction);
            switch (copiedObjectAction.getStatus().get(0)) {
                case INSERT:
                    copiedObjectAction.getStatus().set(0, ActionStatusEnum.DELETE);
                    break;
                case UPDATE:
                    Collections.swap(copiedObjectAction.getObjects(), 0, 1);
                    break;
                case DELETE:
                    copiedObjectAction.getStatus().set(0, ActionStatusEnum.INSERT);
                    break;
            }
            redoStack.push(copiedObjectAction);
            return objectAction;
        }
        return null;
    }
    
    public ObjectAction redo() {
        if (!redoStack.isEmpty()) {
            ObjectAction objectAction = redoStack.pop();
            ObjectAction copiedObjectAction = new ObjectAction(objectAction);
            switch (copiedObjectAction.getStatus().get(0)) {
                case INSERT:
                    copiedObjectAction.getStatus().set(0, ActionStatusEnum.DELETE);
                    break;
                case UPDATE:
                    Collections.swap(copiedObjectAction.getObjects(), 0, 1);
                    break;
                case DELETE:
                    copiedObjectAction.getStatus().set(0, ActionStatusEnum.INSERT);
                    break;
            }
            undoStack.push(copiedObjectAction);
            return objectAction;
        }
        return null;
    }
    
    public void reset() {
        undoStack.clear();
        redoStack.clear();
    }
    
//    Getters and setters
    public Stack<ObjectAction> getUndoStack() {
        return undoStack;
    }

    public void setUndoStack(Stack<ObjectAction> undoStack) {
        this.undoStack = undoStack;
    }

    public Stack<ObjectAction> getRedoStack() {
        return redoStack;
    }

    public void setRedoStack(Stack<ObjectAction> redoStack) {
        this.redoStack = redoStack;
    }
}
