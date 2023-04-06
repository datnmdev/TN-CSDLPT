/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.global_variable;

import com.ptithcm.tn_csdlpt.configuration.DatabaseConnector;

/**
 *
 * @author MINHDAT
 */
public class LoginVariables implements ResetInterface {
    public static DatabaseConnector databaseConnector;

    @Override
    public void reset() {
        databaseConnector = null;
    }
}
