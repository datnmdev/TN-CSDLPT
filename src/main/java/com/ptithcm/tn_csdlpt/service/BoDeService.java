/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.ptithcm.tn_csdlpt.entity.BoDe;
import com.ptithcm.tn_csdlpt.model.dto.ObjectAction;
import com.ptithcm.tn_csdlpt.repository.BoDeRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MINHDAT
 */
public class BoDeService {
    public List<Object> getAllQuestions() throws SQLException {
        return new BoDeRepository().findAll();
    }
    
    public static void saveAll(List<ObjectAction> objectActions) throws SQLException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        SQLServerDataTable sqlServerDataTable = SQLConvert.toT_CAUHOI(Filter.getChangedObjectActions(objectActions));
        BoDeRepository boDeRepository = new BoDeRepository();
        boDeRepository.saveAll(sqlServerDataTable);
    }
    
    public List<String> getLevelList() throws SQLException {
        return new BoDeRepository().getLevelList();
    }
    
    public List<BoDe> toBoDe(List<Object> objects) {
        List<BoDe> questions = new ArrayList<>();
        objects.forEach(object -> questions.add((BoDe) object));
        return questions;
    }
}
