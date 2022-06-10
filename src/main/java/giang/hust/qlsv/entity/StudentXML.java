package giang.hust.qlsv.entity;

import giang.hust.qlsv.entity.Student;

import java.util.ArrayList;

//@XmlRootElement(name = "students")
//@XmlAccessorType(XmlAccessType.FIELD)
public class StudentXML {
    private ArrayList<Student> students;

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
