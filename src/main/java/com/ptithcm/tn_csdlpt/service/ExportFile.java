/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author MINHDAT
 */
public class ExportFile {

    public static void exportFileWord(String title, String info, JTable jTable, String path) throws IOException {
        DefaultTableModel jTableModel = (DefaultTableModel) jTable.getModel();

        // Tạo một tài liệu Word mới
        XWPFDocument document = new XWPFDocument();

        // tạo đoạn văn bản mới
        XWPFParagraph titleContent = document.createParagraph();
        XWPFRun run = titleContent.createRun();
        run.setText(title);
        run.setFontFamily("Times New Roman");
        run.setBold(true);
        run.setFontSize(24);

        // thêm xuống dòng
        titleContent = document.createParagraph();

        // Thông tin liên quan       
        XWPFParagraph infoContent = document.createParagraph();
        run = infoContent.createRun();
        run.setText(info);
        run.setFontFamily("Times New Roman");
        run.setBold(false);
        run.setFontSize(16);

        // thêm xuống dòng
        infoContent = document.createParagraph();

        // Tạo bảng để chứa dữ liệu
        XWPFTable table = document.createTable();

        // Thêm các tiêu đề cột
        int columnCount = jTableModel.getColumnCount();
        XWPFTableRow headerRow = table.getRow(0);
        if (headerRow == null) {
            headerRow = table.createRow();
        }
        for (int i = 0; i < columnCount; i++) {
            XWPFTableCell cell = headerRow.getCell(i);
            if (cell == null) {
                cell = headerRow.createCell();
            }
            cell.setText(jTableModel.getColumnName(i));
        }

        // Thêm dữ liệu vào bảng
        int rowCount = jTableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            // Tạo một hàng mới trong bảng Word
            XWPFTableRow row = table.createRow();
            for (int j = 0; j < jTableModel.getColumnCount(); j++) {
                // Lấy dữ liệu từ JTable
                Object cellData = jTableModel.getValueAt(i, j);

                // Thêm ô vào hàng mới
                XWPFTableCell cell = row.getCell(j);
                if (cell == null) {
                    cell = row.createCell();
                }
                if (cellData != null) {
                    cell.setText(cellData.toString());
                } else {
                    cell.setText("");
                }
            }
        }

        // Ghi tài liệu ra file Word
        try (FileOutputStream out = new FileOutputStream(new File(path));) {
            document.write(out);
        }

        // Giải phóng bộ nhớ
        document.close();
    }

    public static void exportFileExcel(JTable jTable, String path) throws Exception {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet 1");

            // Tạo hàng tiêu đề
            XSSFRow headerRow = sheet.createRow(0);
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                XSSFCell headerCell = headerRow.createCell(i);
                headerCell.setCellValue(tableModel.getColumnName(i));
            }

            // Tạo các hàng dữ liệu
            for (int row = 0; row < tableModel.getRowCount(); row++) {
                XSSFRow dataRow = sheet.createRow(row + 1);
                for (int col = 0; col < tableModel.getColumnCount(); col++) {
                    XSSFCell dataCell = dataRow.createCell(col);
                    dataCell.setCellValue(tableModel.getValueAt(row, col).toString());
                }
            }

            // Lưu workbook ra file Excel
            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void exportFilePDF(String title, String author, JTable jJTable, String path) throws FileNotFoundException, DocumentException, IOException {
        try (FileOutputStream out = new FileOutputStream(path);) {
            DefaultTableModel tableModel = (DefaultTableModel) jJTable.getModel();

            // Tạo đối tượng Document
            Document document = new Document();

            // Lưu tài liệu PDF ra file
            PdfWriter.getInstance(document, out);

            // Mở Document để bắt đầu thêm nội dung
            document.open();

            // Thêm các thông tin về tài liệu
            document.addTitle(title);
            document.addAuthor(author);

            // Tạo bảng PDF
            PdfPTable table = new PdfPTable(tableModel.getColumnCount());

            // Thêm các tiêu đề của bảng
            for (int i = 0; i < tableModel.getColumnCount(); i++) {
                table.addCell(tableModel.getColumnName(i));
            }

            // Thêm các dòng dữ liệu vào bảng
            for (int row = 0; row < tableModel.getRowCount(); row++) {
                for (int col = 0; col < tableModel.getColumnCount(); col++) {
                    table.addCell(tableModel.getValueAt(row, col).toString());
                }
            }

            // Thêm bảng PDF vào tài liệu PDF
            document.add(table);

            // Đóng Document để kết thúc thêm nội dung
            document.close();
        }
    }
}
