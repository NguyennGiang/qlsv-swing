package giang.hust.qlsv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentDao {
    private static final String STUDENT_FILE_NAME = "student.xml";
    private ArrayList<Student> listStudent;

    public StudentDao(){
        this.listStudent = readListStudents();
    }

    public void writeListStudents(ArrayList<Student> students){
        StudentXML studentXML = new StudentXML();
        studentXML.setStudents(students);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, studentXML);
    }

    public ArrayList<Student> readListStudents(){
        ArrayList<Student> list = new ArrayList<>();
        StudentXML studentXML = (StudentXML) FileUtils.readXMLFile(
                STUDENT_FILE_NAME, StudentXML.class
        );
        if (studentXML != null){
            list = studentXML.getStudents();
        }
        return list;
    }

    public void add(Student student) {
        int id = (listStudent.size() > 0) ? (listStudent.size() + 1) : 1;
        student.setId(id);
        listStudent.add(student);
        writeListStudents(listStudent);
    }

    public void edit(Student student) {
        int size = listStudent.size();
        for (int i = 0; i < size; i++) {
            if (listStudent.get(i).getId() == student.getId()) {
                listStudent.get(i).setName(student.getName());
                listStudent.get(i).setAge(student.getAge());
                listStudent.get(i).setAddress(student.getAddress());
                listStudent.get(i).setCpa(student.getCpa());
                writeListStudents(listStudent);
                break;
            }
        }
    }

    public boolean delete(Student student) {
        boolean isFound = false;
        int size = listStudent.size();
        for (int i = 0; i < size; i++) {
            if (listStudent.get(i).getId() == student.getId()) {
                student = listStudent.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listStudent.remove(student);
            writeListStudents(listStudent);
            return true;
        }
        return false;
    }

    public void sortStudentByName() {
        Collections.sort(listStudent, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getName().compareTo(student2.getName());
            }
        });
    }

    public void sortStudentByCPA() {
        Collections.sort(listStudent, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                if (student1.getCpa() > student2.getCpa()) {
                    return -1;
                }
                return 1;
            }
        });
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudents(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

}
