package giang.hust.qlsv.controller;

import giang.hust.qlsv.dao.StudentDao;
import giang.hust.qlsv.view.StudentView;
import giang.hust.qlsv.entity.Student;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentController {
    private StudentDao studentDao;
    private StudentView studentView;

    public StudentController(StudentView view) {
        this.studentView = view;
        studentDao = new StudentDao();

        view.addAddStudentListener(new AddStudentListener());
        view.addEdiStudentListener(new EditStudentListener());
        view.addDeleteStudentListener(new DeleteStudentListener());
        view.addClearListener(new ClearStudentListener());
        view.addSortStudentGPAListener(new SortStudentCPAListener());
        view.addSortStudentNameListener(new SortStudentNameListener());
        view.addListStudentSelectionListener(new ListStudentSelectionListener());
        view.addExportFile(new ExportFile());
    }

    public void showStudentView() {
        ArrayList<Student> studentList = studentDao.getListStudent();
        studentView.setVisible(true);
        studentView.showListStudents(studentList);
    }

    class ExportFile implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            studentDao.writeListStudents(studentDao.getListStudent());
        }
    }

    class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                if(studentDao.add(student)){
                    studentView.showMessage("Them thanh cong");
                }
                else {
                    studentView.showMessage("Mã số sinh viên đã tồn tại");
                }
                studentView.showStudent(student);
                studentView.showListStudents(studentDao.getListStudent());
            }
        }
    }

    class EditStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentDao.edit(student);
                studentView.showStudent(student);
                studentView.showListStudents(studentDao.getListStudent());
                studentView.showMessage("Cập nhật thành công!");
            }
        }
    }

    class DeleteStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentDao.delete(student);
                studentView.clearStudentInfo();
                studentView.showListStudents(studentDao.getListStudent());
                studentView.showMessage("Xóa thành công!");
            }
        }
    }

    class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentView.clearStudentInfo();
        }
    }

    class SortStudentCPAListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentDao.sortStudentByCPA();
            studentView.showListStudents(studentDao.getListStudent());
        }
    }

    class SortStudentNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentDao.sortStudentByName();
            studentView.showListStudents(studentDao.getListStudent());
        }
    }

    class ListStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            studentView.fillStudentFromSelectedRow();
        }
    }
}
