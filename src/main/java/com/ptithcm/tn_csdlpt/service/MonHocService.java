/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.ptithcm.tn_csdlpt.entity.MonHoc;
import com.ptithcm.tn_csdlpt.repository.MonHocRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINHDAT
 */
public class MonHocService {
     public MonHoc getSubject(String maMH) throws SQLException {
        return (MonHoc) (new MonHocRepository().find(maMH));
    }
    
    public List<MonHoc> getAllSubjects() throws SQLException {
        return toSubjects(new MonHocRepository().findAll());
    }
    
    public List<MonHoc> toSubjects(List<Object> objects) {
        List<MonHoc>  subjects = new ArrayList<>();
        objects.forEach(object -> subjects.add((MonHoc) object));
        return subjects;
    }
}
