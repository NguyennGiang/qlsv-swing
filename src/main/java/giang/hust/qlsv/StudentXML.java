package giang.hust.qlsv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

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
