/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.ptithcm.tn_csdlpt.entity.GiaoVien;
import com.ptithcm.tn_csdlpt.repository.GiaoVienRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINHDAT
 */
public class GiaoVienService {
    public GiaoVien getTeacher(String maGV) throws SQLException {
        return (GiaoVien) (new GiaoVienRepository().find(maGV));
    }
    
    public List<GiaoVien> getAllTeachers() throws SQLException {
        return  toTeachers(new GiaoVienRepository().findAll());
    }
    
    public List<GiaoVien> toTeachers(List<Object> objects) {
        List<GiaoVien> teachers = new ArrayList<>();
        objects.forEach(object -> teachers.add((GiaoVien) object));
        return teachers;
    }
}
