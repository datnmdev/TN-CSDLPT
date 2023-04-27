/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptithcm.tn_csdlpt.service;

import com.ptithcm.tn_csdlpt.entity.GiaoVien;
import com.ptithcm.tn_csdlpt.entity.Khoa;
import com.ptithcm.tn_csdlpt.entity.Lop;
import com.ptithcm.tn_csdlpt.entity.MonHoc;
import com.ptithcm.tn_csdlpt.entity.SinhVien;
import com.ptithcm.tn_csdlpt.exception.InvalidInputException;
import com.ptithcm.tn_csdlpt.model.dto.ActionStatusEnum;
import com.ptithcm.tn_csdlpt.model.dto.ObjectAction;
import com.ptithcm.tn_csdlpt.repository.GiaoVienRepository;
import com.ptithcm.tn_csdlpt.repository.KhoaRepository;
import com.ptithcm.tn_csdlpt.repository.LopRepository;
import com.ptithcm.tn_csdlpt.repository.MonHocRepository;
import com.ptithcm.tn_csdlpt.repository.SinhVienRepository;
import com.ptithcm.tn_csdlpt.view.FrmLogin;
import com.ptithcm.tn_csdlpt.view.PnlKhoaInfo;
import com.ptithcm.tn_csdlpt.view.PnlLopInfo;
import com.ptithcm.tn_csdlpt.view.PnlMonHocInfo;
import com.ptithcm.tn_csdlpt.view.PnlQuestionInfo;
import com.ptithcm.tn_csdlpt.view.PnlStudentInfo;
import com.ptithcm.tn_csdlpt.view.PnlTeacherInfo;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MINHDAT
 */
public class ValidateFormService {

    public static void validateFrmLogin(FrmLogin frmLogin) throws InvalidInputException {
        if (frmLogin.getTxtLoginName().getText().isEmpty()) {
            throw new InvalidInputException("Vui lòng nhập tên đăng nhập!");
        } else if (String.valueOf(frmLogin.getTxtPassword().getPassword()).isEmpty()) {
            throw new InvalidInputException("Vui lòng nhập mật khẩu!");
        }
    }

    public static void validateFrmQuestionInfo(PnlQuestionInfo pnlQuestionInfo) throws InvalidInputException {
        if (pnlQuestionInfo.getTxtAreaContent().getText().equals("")) {
            throw new InvalidInputException("Nội dung câu hỏi không được bỏ trống!");
        } else if (pnlQuestionInfo.getTxtAreaQuestionA().getText().equals("")) {
            throw new InvalidInputException("Nội dung câu A không được bỏ trống!");
        } else if (pnlQuestionInfo.getTxtAreaQuestionB().getText().equals("")) {
            throw new InvalidInputException("Nội dung câu B không được bỏ trống!");
        } else if (pnlQuestionInfo.getTxtAreaQuestionC().getText().equals("")) {
            throw new InvalidInputException("Nội dung câu C không được bỏ trống!");
        } else if (pnlQuestionInfo.getTxtAreaQuestionA().getText().equals("")) {
            throw new InvalidInputException("Nội dung câu D không được bỏ trống!");
        } else if (pnlQuestionInfo.getTxtAreaQuestionA().getText().equals(pnlQuestionInfo.getTxtAreaQuestionB().getText())
                || pnlQuestionInfo.getTxtAreaQuestionA().getText().equals(pnlQuestionInfo.getTxtAreaQuestionC().getText())
                || pnlQuestionInfo.getTxtAreaQuestionA().getText().equals(pnlQuestionInfo.getTxtAreaQuestionD().getText())
                || pnlQuestionInfo.getTxtAreaQuestionB().getText().equals(pnlQuestionInfo.getTxtAreaQuestionC().getText())
                || pnlQuestionInfo.getTxtAreaQuestionB().getText().equals(pnlQuestionInfo.getTxtAreaQuestionD().getText())
                || pnlQuestionInfo.getTxtAreaQuestionC().getText().equals(pnlQuestionInfo.getTxtAreaQuestionD().getText())) {
            throw new InvalidInputException("Các đáp án A, B, C, D không được trùng nhau!");
        }
    }

    // code by hai mai
    //hàm bắt lỗi cho giáo viên nút thêm
    public static void validateFrmTeacherInfoAdd(PnlTeacherInfo pnlTeacherInfo, List<ObjectAction> objectActions) throws InvalidInputException, SQLException {

        if (pnlTeacherInfo.getTxtTeacherID().getText().strip().equals("")) {
            throw new InvalidInputException("Mã giảng viên không được bỏ trống!");
        } else if (pnlTeacherInfo.getTxtHo().getText().strip().equals("")) {
            throw new InvalidInputException("Họ không được bỏ trống!");
        } else if (pnlTeacherInfo.getTxtTen().getText().strip().equals("")) {
            throw new InvalidInputException("Tên không được bỏ trống!");
        } else if (GiaoVienRepository.checkMaGV(pnlTeacherInfo.getTxtTeacherID().getText())) {
            throw new InvalidInputException("Mã giảng viên còn tồn tại trong cơ sở dữ liệu !");
        }

        for (int i = 0; i < objectActions.size(); ++i) {
            GiaoVien gv = (GiaoVien) objectActions.get(i).getObjects().get(0);
            if (pnlTeacherInfo.getTxtTeacherID().getText().strip().equals(gv.getMaGV().strip())) {
                throw new InvalidInputException("Mã giảng viên còn tồn tại trong bộ nhớ tạm bạn hãy ghi lại hoặc là undo!");
            }
        }
    }

    //hàm bắt lỗi cho giáo viên nút chỉnh sửa
    public static void validateFrmTeacherInfoUpdate(PnlTeacherInfo pnlTeacherInfo, String magv) throws SQLException, InvalidInputException {

        if (pnlTeacherInfo.getTxtTeacherID().getText().strip().equals("")) {
            throw new InvalidInputException("Mã giảng viên không được bỏ trống!");
        } else if (pnlTeacherInfo.getTxtHo().getText().strip().equals("")) {
            throw new InvalidInputException("Họ không được bỏ trống!");
        } else if (pnlTeacherInfo.getTxtTen().getText().strip().equals("")) {
            throw new InvalidInputException("Tên không được bỏ trống!");
        } else if (GiaoVienRepository.checkMaGV(magv)) {
            if (pnlTeacherInfo.getTxtTeacherID().getText().strip().equals(magv.strip()) == false) {
                throw new InvalidInputException("Mã giảng viên không được sửa đổi");
            }
        }

    }

    //hàm bắt lỗi cho sinh viên
    public static void validateFrmStudentInfoAdd(PnlStudentInfo pnlStudentInfo, List<ObjectAction> objectActions) throws InvalidInputException, SQLException {

        if (pnlStudentInfo.getTxtMaSV().getText().strip().equals("")) {
            throw new InvalidInputException("Mã sinh viên  không được bỏ trống!");
        } else if (pnlStudentInfo.getTxtHo().getText().strip().equals("")) {
            throw new InvalidInputException("Họ không được bỏ trống!");
        } else if (pnlStudentInfo.getTxtTen().getText().strip().equals("")) {
            throw new InvalidInputException("Tên không được bỏ trống!");
        } else if (pnlStudentInfo.getTxtNgaySinh().getText().strip().equals("")) {
            throw new InvalidInputException("Ngày sinh không được bỏ trống!");
        } else if (SinhVienRepository.checkMaSV(pnlStudentInfo.getTxtMaSV().getText())) {
            throw new InvalidInputException("Mã sinh viên còn tồn tại trong cơ sở dữ liệu !");
        }

        for (int i = 0; i < objectActions.size(); ++i) {
            SinhVien gv = (SinhVien) objectActions.get(i).getObjects().get(0);
            if (pnlStudentInfo.getTxtMaSV().getText().strip().equals(gv.getMaSV().strip())) {
                throw new InvalidInputException("Mã sinh viên còn tồn tại trong bộ nhớ tạm bạn hãy ghi lại hoặc là undo!");
            }
        }
    }

    public static void validateFrmStudentInfoUpdate(PnlStudentInfo pnlStudentInfo, String magv) throws SQLException, InvalidInputException {

        if (pnlStudentInfo.getTxtMaSV().getText().strip().equals("")) {
            throw new InvalidInputException("Mã sinh viên không được bỏ trống!");
        } else if (pnlStudentInfo.getTxtHo().getText().strip().equals("")) {
            throw new InvalidInputException("Họ không được bỏ trống!");
        } else if (pnlStudentInfo.getTxtTen().getText().strip().equals("")) {
            throw new InvalidInputException("Tên không được bỏ trống!");
        } else if (pnlStudentInfo.getTxtNgaySinh().getText().strip().equals("")) {
            throw new InvalidInputException("Ngày sinh không được bỏ trống!");
        } else if (SinhVienRepository.checkMaSV(magv)) {
            if (pnlStudentInfo.getTxtMaSV().getText().strip().equals(magv.strip()) == false) {
                throw new InvalidInputException("Mã sinh viên không được sửa đổi");
            }
        }

    }

    //hàm bắt lỗi cho môn học
    public static void validateFrmMonInfoAdd(PnlMonHocInfo pnlMonHocInfo, List<ObjectAction> objectActions) throws InvalidInputException, SQLException {

        if (pnlMonHocInfo.getTxtMaMH().getText().strip().equals("")) {
            throw new InvalidInputException("Mã môn học không được bỏ trống!");
        } else if (pnlMonHocInfo.getTxtTenMH().getText().strip().equals("")) {
            throw new InvalidInputException("Mã môn học không được bỏ trống!");
        } else if (pnlMonHocInfo.getTxtMaMH().getText().strip().length() > 5) {
            throw new InvalidInputException("Mã môn học không được vượt quá 5 kí tự");
        } else if (MonHocRepository.checkMaMon(pnlMonHocInfo.getTxtMaMH().getText())) {
            throw new InvalidInputException("Mã môn học còn tồn tại trong cơ sở dữ liệu !");
        }

        for (int i = 0; i < objectActions.size(); ++i) {
            MonHoc gv = (MonHoc) objectActions.get(i).getObjects().get(0);
            if (pnlMonHocInfo.getTxtMaMH().getText().strip().equals(gv.getMaMH().strip())) {
                throw new InvalidInputException("Mã môn học còn tồn tại trong bộ nhớ tạm bạn hãy ghi lại hoặc là undo!");
            }
        }
    }

    public static void validateFrmMonInfoUpdate(PnlMonHocInfo pnlMonHocInfo, List<ObjectAction> objectActions, String magv) throws SQLException, InvalidInputException {
        if (pnlMonHocInfo.getTxtMaMH().getText().strip().equals("")) {
            throw new InvalidInputException("Mã môn học không được bỏ trống!");
        } else if (pnlMonHocInfo.getTxtMaMH().getText().strip().equals("")) {
            throw new InvalidInputException("Mã môn học được bỏ trống!");
        }

        for (int i = 0; i < objectActions.size(); ++i) {
            MonHoc gv = (MonHoc) objectActions.get(i).getObjects().get(0);
            if (pnlMonHocInfo.getTxtMaMH().getText().strip().equals(gv.getMaMH().strip())) {
                throw new InvalidInputException("Mã môn học còn tồn tại ");
            }
        }

    }

    //hàm bắt lỗi khoa
    public static void validateFrmKhoaInfoAdd(PnlKhoaInfo pnlKhoaInfo, List<ObjectAction> objectActions) throws InvalidInputException, SQLException {

        if (pnlKhoaInfo.getTxtMaMH().getText().strip().equals("")) {
            throw new InvalidInputException("Mã khoa không được bỏ trống!");
        } else if (pnlKhoaInfo.getTxtTenMH().getText().strip().equals("")) {
            throw new InvalidInputException("Tên khoa được bỏ trống!");
        } else if (KhoaRepository.checkMaKhoa(pnlKhoaInfo.getTxtMaMH().getText())) {
            throw new InvalidInputException("Mã khoa còn tồn tại trong cơ sở dữ liệu !");
        }

        for (int i = 0; i < objectActions.size(); ++i) {
            Khoa gv = (Khoa) objectActions.get(i).getObjects().get(0);
            if (pnlKhoaInfo.getTxtMaMH().getText().strip().equals(gv.getMaKH().strip())) {
                throw new InvalidInputException("Mã khoa còn tồn tại trong bộ nhớ tạm bạn hãy ghi lại hoặc là undo!");
            }
        }
    }

    public static void validateFrmKhoaInfoUpdate(PnlKhoaInfo pnlKhoaInfo, String magv) throws SQLException, InvalidInputException {
        if (pnlKhoaInfo.getTxtMaMH().getText().strip().equals("")) {
            throw new InvalidInputException("Mã khoa không được bỏ trống!");
        } else if (pnlKhoaInfo.getTxtTenMH().getText().strip().equals("")) {
            throw new InvalidInputException("Mã khoa được bỏ trống!");
        } else if (KhoaRepository.checkMaKhoa(magv)) {
            if (pnlKhoaInfo.getTxtMaMH().getText().strip().equals(magv.strip()) == false) {
                throw new InvalidInputException("Mã khoa không được sửa đổi");
            }
        }

    }

    //hàm bắt lỗi lop
    public static void validateFrmLopInfoAdd(PnlLopInfo pnlLopInfo, List<ObjectAction> objectActions) throws InvalidInputException, SQLException {

        if (pnlLopInfo.getTxtMaMH().getText().strip().equals("")) {
            throw new InvalidInputException("Mã lop không được bỏ trống!");
        } else if (pnlLopInfo.getTxtTenMH().getText().strip().equals("")) {
            throw new InvalidInputException("Tên lop được bỏ trống!");
        } else if (LopRepository.checkMaLop(pnlLopInfo.getTxtMaMH().getText())) {
            throw new InvalidInputException("Mã lop còn tồn tại trong cơ sở dữ liệu !");
        }

        for (int i = 0; i < objectActions.size(); ++i) {
            Lop gv = (Lop) objectActions.get(i).getObjects().get(0);
            if (pnlLopInfo.getTxtMaMH().getText().strip().equals(gv.getMaLop().strip())) {
                throw new InvalidInputException("Mã khoa còn tồn tại trong bộ nhớ tạm bạn hãy ghi lại hoặc là undo!");
            }
        }
    }

    public static void validateFrmLopInfoUpdate(PnlLopInfo pnlLopInfo, String magv) throws SQLException, InvalidInputException {
        if (pnlLopInfo.getTxtMaMH().getText().strip().equals("")) {
            throw new InvalidInputException("Mã khoa không được bỏ trống!");
        } else if (pnlLopInfo.getTxtTenMH().getText().strip().equals("")) {
            throw new InvalidInputException("Mã khoa được bỏ trống!");
        } else if (LopRepository.checkMaLop(magv)) {
            if (pnlLopInfo.getTxtMaMH().getText().strip().equals(magv.strip()) == false) {
                throw new InvalidInputException("Mã khoa không được sửa đổi");
            }
        }

    }

    //hàm báo lỗi form báo cáo thi
    public static void validateFrmReportBaoCaoDangKi(JDateChooser txtFromDate,JDateChooser txtEndDate ) throws SQLException, InvalidInputException {
        if (txtEndDate.getDate() == null ) {
            throw new InvalidInputException("Ngày kết thúc không hợp lệ!");
        } else if ( txtFromDate.getDate() == null) {
            throw new InvalidInputException("Ngày bắt đầu không hợp lệ!");
        } else if (txtEndDate.getDate().before(txtFromDate.getDate())) {
            throw new InvalidInputException("Ngày kết thúc không được nhỏ hơn ngày bắt đầu!");
        }else if ( !txtFromDate.isValid()) {
            throw new InvalidInputException("Ngày bắt đầu không hợp lệ");
        }else if ( !txtEndDate.isValid()) {
            throw new InvalidInputException("Ngày kết thúc không hợp lệ");
        }

    }

    
}
