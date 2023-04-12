/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptithcm.tn_csdlpt.repository;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import java.sql.SQLException;

/**
 *
 * @author MINHDAT
 */
public interface SaveDataRepositoryInterface {
    public abstract void saveAll(SQLServerDataTable sqlServerDataTable) throws SQLException;
}
