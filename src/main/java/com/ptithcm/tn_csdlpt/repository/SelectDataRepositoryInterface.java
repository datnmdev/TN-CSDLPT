/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MINHDAT
 */
public interface SelectDataRepositoryInterface {
    public abstract List<Object> findAll() throws SQLException;
    public abstract Object find(Object object) throws SQLException;
}
