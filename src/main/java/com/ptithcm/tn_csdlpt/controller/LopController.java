/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.controller;

import com.ptithcm.tn_csdlpt.entity.GiaoVien;
import com.ptithcm.tn_csdlpt.entity.Khoa;
import com.ptithcm.tn_csdlpt.entity.Lop;
import com.ptithcm.tn_csdlpt.model.dto.GiaoVienDto;
import com.ptithcm.tn_csdlpt.service.BoDeService;
import com.ptithcm.tn_csdlpt.repository.GiaoVienRepository;
import com.ptithcm.tn_csdlpt.repository.KhoaRepository;
import com.ptithcm.tn_csdlpt.repository.LopRepository;
import com.ptithcm.tn_csdlpt.repository.MonHocRepository;
import com.ptithcm.tn_csdlpt.repository.SinhVienRepository;
import com.ptithcm.tn_csdlpt.service.GiaoVienService;
import com.ptithcm.tn_csdlpt.service.LopService;
import com.ptithcm.tn_csdlpt.service.SinhVienService;
import com.ptithcm.tn_csdlpt.view.FrmMain;
import com.ptithcm.tn_csdlpt.view.MessageBox;
import com.ptithcm.tn_csdlpt.view.PnlKhoaManager;
import com.ptithcm.tn_csdlpt.view.PnlLopManager;
import com.ptithcm.tn_csdlpt.view.PnlMonHocManager;
import com.ptithcm.tn_csdlpt.view.PnlStudentManager;
import com.ptithcm.tn_csdlpt.view.PnlTeacherInfo;
import com.ptithcm.tn_csdlpt.view.PnlTeacherManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HP
 */
public class LopController {
    
    public static void renderData(PnlLopManager pnlWorkSection , String Makh) throws SQLException {
        pnlWorkSection.setObjectActions(new LopRepository().findAllMAKH(Makh));
        pnlWorkSection.fillTableForTeacher(pnlWorkSection.getObjectActions());
    }

}
