/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.controller;

import com.ptithcm.tn_csdlpt.global_variable.SubscribersVariables;
import com.ptithcm.tn_csdlpt.service.SubscriberService;
import com.ptithcm.tn_csdlpt.view.ExceptionMessageBox;
import com.ptithcm.tn_csdlpt.view.FrmLogin;
import java.io.IOException;

/**
 *
 * @author MINHDAT
 */
public class LoginController {
    
//    Hiển thị danh sách các server phân mảnh lên combobox
    public static void renderActiveSubcribers(FrmLogin frmLogin) {
        try {
            frmLogin.fillSideComboBox(
                    new SubscriberService().getActiveSubcribers(
                            SubscribersVariables.subscribers
                    )
            );
        } catch (IOException ex) {
            ExceptionMessageBox.showErrorBox(ex.getClass().getName(), ex.getMessage());
        }
    }
}
