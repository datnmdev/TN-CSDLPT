/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.view;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author MINHDAT
 */
public class FileChooser {
    public String getPathFromFileChooser(String extentionName, String extention) {
        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter(extentionName, extention);
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showSaveDialog(null);
        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (!filePath.endsWith(extention)) {
                filePath += extention;
            }
            if (fileChooser.getSelectedFile().getName().trim().equals("")) {
                MessageBox.showErrorBox("Error", "Vui lòng nhập tên file trước khi bấm nút lưu!");
            } else {
                return filePath;
            }
        }
        return null;
    }
}
