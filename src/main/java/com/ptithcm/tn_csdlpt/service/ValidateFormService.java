/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.ptithcm.tn_csdlpt.exception.InvalidInputException;
import com.ptithcm.tn_csdlpt.view.FrmLogin;
import com.ptithcm.tn_csdlpt.view.PnlQuestionInfo;

/**
 *
 * @author MINHDAT
 */
public class ValidateFormService {
    public static void validateFrmLogin(FrmLogin frmLogin) throws InvalidInputException {
        if (frmLogin.getTxtLoginName().getText().isEmpty()) {
            throw new InvalidInputException("Vui lòng nhập tên đăng nhập!");
        } else if (String.valueOf(frmLogin.getTxtPassword().getPassword()).isEmpty()) {
            throw new InvalidInputException("Vui lòng nhập mật khẩu!");
        }
    }
    
    public static void validateFrmQuestionInfo(PnlQuestionInfo pnlQuestionInfo) throws InvalidInputException {
        if (pnlQuestionInfo.getTxtAreaContent().getText().equals("")) {
            throw new InvalidInputException("Nội dung câu hỏi không được bỏ trống!");
        } else if (pnlQuestionInfo.getTxtAreaQuestionA().getText().equals("")) {
            throw new InvalidInputException("Nội dung câu A không được bỏ trống!");
        } else if (pnlQuestionInfo.getTxtAreaQuestionB().getText().equals("")) {
            throw new InvalidInputException("Nội dung câu B không được bỏ trống!");
        } else if (pnlQuestionInfo.getTxtAreaQuestionC().getText().equals("")) {
            throw new InvalidInputException("Nội dung câu C không được bỏ trống!");
        } else if (pnlQuestionInfo.getTxtAreaQuestionA().getText().equals("")) {
            throw new InvalidInputException("Nội dung câu D không được bỏ trống!");
        } else if (pnlQuestionInfo.getTxtAreaQuestionA().getText().equals(pnlQuestionInfo.getTxtAreaQuestionB().getText()) || 
                pnlQuestionInfo.getTxtAreaQuestionA().getText().equals(pnlQuestionInfo.getTxtAreaQuestionC().getText()) || 
                pnlQuestionInfo.getTxtAreaQuestionA().getText().equals(pnlQuestionInfo.getTxtAreaQuestionD().getText()) || 
                pnlQuestionInfo.getTxtAreaQuestionB().getText().equals(pnlQuestionInfo.getTxtAreaQuestionC().getText()) || 
                pnlQuestionInfo.getTxtAreaQuestionB().getText().equals(pnlQuestionInfo.getTxtAreaQuestionD().getText()) || 
                pnlQuestionInfo.getTxtAreaQuestionC().getText().equals(pnlQuestionInfo.getTxtAreaQuestionD().getText())) {
            throw new InvalidInputException("Các đáp án A, B, C, D không được trùng nhau!");
        }
    }
}
