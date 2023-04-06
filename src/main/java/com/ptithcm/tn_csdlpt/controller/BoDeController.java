/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.controller;

import com.ptithcm.tn_csdlpt.service.BoDeService;
import com.ptithcm.tn_csdlpt.service.MonHocService;
import com.ptithcm.tn_csdlpt.view.FrmMain;
import com.ptithcm.tn_csdlpt.view.MessageBox;
import com.ptithcm.tn_csdlpt.view.PnlWorkSection;
import java.sql.SQLException;

/**
 *
 * @author MINHDAT
 */
public class BoDeController {
    public static void renderData(FrmMain frmMain, PnlWorkSection pnlWorkSection) {
        try {
            pnlWorkSection.setQuestions(new BoDeService().getAllQuestions());
            pnlWorkSection.fillDataTable(pnlWorkSection.getQuestions());
            pnlWorkSection.getPnlQuestionInfo().fillSubjectComboBox(new MonHocService().getAllSubjects());
            pnlWorkSection.getPnlQuestionInfo().fillLevelComboBox(new BoDeService().getLevelList());
        } catch (SQLException ex) {
            MessageBox.showErrorBox(ex.getClass().getName(), ex.getMessage());
        }
    }
    
    
}
