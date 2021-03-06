package domain.Classes;

import domain.Interfaces.PrintObject;
import java.io.Serializable;


public class Student implements PrintObject, Serializable {
    private final int DEFOULT_MARK = 2;
    private final String DEFOULT_DISCIPLINE = "Math";
    private final String DEFOULT_TEACHER_NAME = "Oleg";

    private long id;
    private String firstName;
    private String lastName;
    private int group;
    private String department;
    private String discipline;
    private int mark;
    private String teacherName;

    public Student(String firstName, String lastName, int group, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.department = department;
        this.discipline = DEFOULT_DISCIPLINE;
        this.mark = DEFOULT_MARK;
        this.teacherName = DEFOULT_TEACHER_NAME;
        setId();
    }

    public long getId(){
        return id;
    }

    private void setId(){
        this.id = System.currentTimeMillis();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getTeacheName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Student id: " + id +
                ", firstName: " + firstName +
                ", lastName: " + lastName +
                ", group: " + group +
                ", department: " + department +
                ", discipline: " + discipline +
                ", mark: " + mark +
                ", teacher name: " + teacherName;
    }
}