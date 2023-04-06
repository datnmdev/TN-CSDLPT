/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ptithcm.tn_csdlpt;

import com.ptithcm.tn_csdlpt.controller.LoginController;
import com.ptithcm.tn_csdlpt.view.FrmLogin;

/**
 *
 * @author MINHDAT
 */
public class Tn_csdlpt {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginController.startFrmLogin(new FrmLogin());
            }
        });
    }
}
