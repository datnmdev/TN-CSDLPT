/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.ptithcm.tn_csdlpt.exception.InvalidInputException;
import com.ptithcm.tn_csdlpt.view.FrmLogin;

/**
 *
 * @author MINHDAT
 */
public class ValidateFormService {
    public void validateFrmLogin(FrmLogin frmLogin) throws InvalidInputException {
        if (frmLogin.getTxtLoginName().getText().isEmpty()) {
            throw new InvalidInputException("Vui lòng nhập tên đăng nhập!");
        } else if (String.valueOf(frmLogin.getTxtPassword().getPassword()).isEmpty()) {
            throw new InvalidInputException("Vui lòng nhập mật khẩu!");
        }
    }
}
