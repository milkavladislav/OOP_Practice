package domain.Collections;

import domain.Classes.Student;
import domain.Interfaces.PrintObject;
import java.io.Serializable;
import java.util.*;

public class StudentCollection implements PrintObject, Serializable {
    private ArrayList<Student> collection = new ArrayList<Student>();

    public void addStudent(Student student){
        collection.add(student);
    }

    public ArrayList<Student> returnCollection(){
        return this.collection;
    }

    public void sortById(){
        Collections.sort(collection, Comparator.comparing(Student::getId));
    }

    public void sortByFirstName(){
        Collections.sort(collection, Comparator.comparing(Student::getFirstName));
    }

    public void sortByLastName(){
        Collections.sort(collection, Comparator.comparing(Student::getLastName));
    }

    public void sortByDepartment(){
        Collections.sort(collection, Comparator.comparing(Student::getDepartment));
    }

    public void sortByGroup(){
        Collections.sort(collection, Comparator.comparing(Student::getGroup));
    }

    @Override
    public String toString() {
        String string = new String("Collection of students :\n");
        for(Student student : collection){
            string += student.toString() + "\n";
        }
        return string;
    }
}
