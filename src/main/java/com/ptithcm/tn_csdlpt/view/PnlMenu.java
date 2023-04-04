/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ptithcm.tn_csdlpt.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author MINHDAT
 */
public class PnlMenu extends javax.swing.JPanel {

    /**
     * Creates new form PnlStatusBar
     */
    public PnlMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabManager = new javax.swing.JTabbedPane();
        tabSystem = new javax.swing.JPanel();
        btnInfoAccount = new javax.swing.JPanel();
        jlabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tabManage = new javax.swing.JPanel();
        btnTeacherManage = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnStudentManage = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnClassroomManage = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnSubjectManage = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnQuestionManage = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tabExam = new javax.swing.JPanel();
        btnExamCalendarRegister = new javax.swing.JPanel();
        btnExamRegister = new javax.swing.JLabel();
        btnDoExam = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnShowExamResult = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tabReport = new javax.swing.JPanel();
        btnReportMarkTable = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnReportExamCalendar = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        tabManager.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabSystem.setBackground(new java.awt.Color(255, 255, 255));
        tabSystem.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnInfoAccount.setBackground(new java.awt.Color(255, 255, 255));

        jlabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/add-user.png"))); // NOI18N
        jlabel1.setText("Thông tin cá nhân");
        btnInfoAccount.add(jlabel1);

        tabSystem.add(btnInfoAccount);

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/logout.png"))); // NOI18N
        jLabel2.setText("Đăng xuất");
        btnLogout.add(jLabel2);

        tabSystem.add(btnLogout);

        tabManager.addTab("HỆ THỐNG", tabSystem);

        tabManage.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout2.setAlignOnBaseline(true);
        tabManage.setLayout(flowLayout2);

        btnTeacherManage.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/teacher.png"))); // NOI18N
        jLabel3.setText("Giảng viên");
        btnTeacherManage.add(jLabel3);

        tabManage.add(btnTeacherManage);

        btnStudentManage.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/student.png"))); // NOI18N
        jLabel4.setText("Sinh viên");
        btnStudentManage.add(jLabel4);

        tabManage.add(btnStudentManage);

        btnClassroomManage.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/classroom.png"))); // NOI18N
        jLabel5.setText("Khoa/Lớp");
        btnClassroomManage.add(jLabel5);

        tabManage.add(btnClassroomManage);

        btnSubjectManage.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/subject.png"))); // NOI18N
        jLabel6.setText("Môn học");
        btnSubjectManage.add(jLabel6);

        tabManage.add(btnSubjectManage);

        btnQuestionManage.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/topic.png"))); // NOI18N
        jLabel7.setText("Bộ đề");
        btnQuestionManage.add(jLabel7);

        tabManage.add(btnQuestionManage);

        tabManager.addTab("DANH MỤC", tabManage);

        tabExam.setBackground(new java.awt.Color(255, 255, 255));
        tabExam.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnExamCalendarRegister.setBackground(new java.awt.Color(255, 255, 255));

        btnExamRegister.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnExamRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExamRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/register.png"))); // NOI18N
        btnExamRegister.setText("Đăng ký thi");
        btnExamCalendarRegister.add(btnExamRegister);

        tabExam.add(btnExamCalendarRegister);

        btnDoExam.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/exam.png"))); // NOI18N
        jLabel11.setText("Tiến hành thi");
        btnDoExam.add(jLabel11);

        tabExam.add(btnDoExam);

        btnShowExamResult.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/test-results.png"))); // NOI18N
        jLabel12.setText("Xem kết quả thi");
        btnShowExamResult.add(jLabel12);

        tabExam.add(btnShowExamResult);

        tabManager.addTab("THI", tabExam);

        tabReport.setBackground(new java.awt.Color(255, 255, 255));
        tabReport.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnReportMarkTable.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/table.png"))); // NOI18N
        jLabel13.setText("Bảng điểm");
        btnReportMarkTable.add(jLabel13);

        tabReport.add(btnReportMarkTable);

        btnReportExamCalendar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/48x48/test-register-list.png"))); // NOI18N
        jLabel16.setText("Danh sách đăng ký thi");
        btnReportExamCalendar.add(jLabel16);

        tabReport.add(btnReportExamCalendar);

        tabManager.addTab("BÁO CÁO", tabReport);

        add(tabManager, "card2");
    }// </editor-fold>//GEN-END:initComponents

//    Getters and setters
    public JPanel getBtnClassroomManage() {
        return btnClassroomManage;
    }

    public void setBtnClassroomManage(JPanel btnClassroomManage) {
        this.btnClassroomManage = btnClassroomManage;
    }

    public JPanel getBtnDoExam() {
        return btnDoExam;
    }

    public void setBtnDoExam(JPanel btnDoExam) {
        this.btnDoExam = btnDoExam;
    }

    public JPanel getBtnExamCalendarRegister() {
        return btnExamCalendarRegister;
    }

    public void setBtnExamCalendarRegister(JPanel btnExamCalendarRegister) {
        this.btnExamCalendarRegister = btnExamCalendarRegister;
    }

    public JLabel getBtnExamRegister() {
        return btnExamRegister;
    }

    public void setBtnExamRegister(JLabel btnExamRegister) {
        this.btnExamRegister = btnExamRegister;
    }

    public JPanel getBtnInfoAccount() {
        return btnInfoAccount;
    }

    public void setBtnInfoAccount(JPanel btnInfoAccount) {
        this.btnInfoAccount = btnInfoAccount;
    }

    public JPanel getBtnLogout() {
        return btnLogout;
    }

    public void setBtnLogout(JPanel btnLogout) {
        this.btnLogout = btnLogout;
    }

    public JPanel getBtnQuestionManage() {
        return btnQuestionManage;
    }

    public void setBtnQuestionManage(JPanel btnQuestionManage) {
        this.btnQuestionManage = btnQuestionManage;
    }

    public JPanel getBtnReportExamCalendar() {
        return btnReportExamCalendar;
    }

    public void setBtnReportExamCalendar(JPanel btnReportExamCalendar) {
        this.btnReportExamCalendar = btnReportExamCalendar;
    }

    public JPanel getBtnReportMarkTable() {
        return btnReportMarkTable;
    }

    public void setBtnReportMarkTable(JPanel btnReportMarkTable) {
        this.btnReportMarkTable = btnReportMarkTable;
    }

    public JPanel getBtnShowExamResult() {
        return btnShowExamResult;
    }

    public void setBtnShowExamResult(JPanel btnShowExamResult) {
        this.btnShowExamResult = btnShowExamResult;
    }

    public JPanel getBtnStudentManage() {
        return btnStudentManage;
    }

    public void setBtnStudentManage(JPanel btnStudentManage) {
        this.btnStudentManage = btnStudentManage;
    }

    public JPanel getBtnSubjectManage() {
        return btnSubjectManage;
    }

    public void setBtnSubjectManage(JPanel btnSubjectManage) {
        this.btnSubjectManage = btnSubjectManage;
    }

    public JPanel getBtnTeacherManage() {
        return btnTeacherManage;
    }

    public void setBtnTeacherManage(JPanel btnTeacherManage) {
        this.btnTeacherManage = btnTeacherManage;
    }

    public JPanel getTabExam() {
        return tabExam;
    }

    public void setTabExam(JPanel tabExam) {
        this.tabExam = tabExam;
    }

    public JPanel getTabManage() {
        return tabManage;
    }

    public void setTabManage(JPanel tabManage) {
        this.tabManage = tabManage;
    }

    public JPanel getTabReport() {
        return tabReport;
    }

    public void setTabReport(JPanel tabReport) {
        this.tabReport = tabReport;
    }

    public JPanel getTabSystem() {
        return tabSystem;
    }

    public void setTabSystem(JPanel tabSystem) {
        this.tabSystem = tabSystem;
    }

    public JTabbedPane getTabManager() {
        return tabManager;
    }

    public void setTabManager(JTabbedPane tabManager) {
        this.tabManager = tabManager;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnClassroomManage;
    private javax.swing.JPanel btnDoExam;
    private javax.swing.JPanel btnExamCalendarRegister;
    private javax.swing.JLabel btnExamRegister;
    private javax.swing.JPanel btnInfoAccount;
    private javax.swing.JPanel btnLogout;
    private javax.swing.JPanel btnQuestionManage;
    private javax.swing.JPanel btnReportExamCalendar;
    private javax.swing.JPanel btnReportMarkTable;
    private javax.swing.JPanel btnShowExamResult;
    private javax.swing.JPanel btnStudentManage;
    private javax.swing.JPanel btnSubjectManage;
    private javax.swing.JPanel btnTeacherManage;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JPanel tabExam;
    private javax.swing.JPanel tabManage;
    private javax.swing.JTabbedPane tabManager;
    private javax.swing.JPanel tabReport;
    private javax.swing.JPanel tabSystem;
    // End of variables declaration//GEN-END:variables
}
