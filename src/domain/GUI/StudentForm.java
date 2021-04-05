package domain.GUI;

import domain.Classes.Student;
import domain.Collections.CloseContactCollection;
import domain.Collections.ContactCollection;
import domain.Collections.OrderCollection;
import domain.Collections.StudentCollection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class StudentForm {
    private final  String nameOfFile = "collections.txt";

    private JTextField FirstNameTextField;
    private JTextField DisciplineTextField;
    private JComboBox MarkComboBox;
    private JButton addOrderButton;
    private JButton sortByNameButton;
    private JButton sortByIdButton;
    private JButton sortByCourierButton;
    private JButton showCollectionButton;
    private JButton saveToFileButton;
    private JButton serializableCollectionButton;
    private JButton deserializableCollectionButton;
    private JTextField LastNameTextField;
    private JSpinner GroupSpinner;
    private JTextField DepartmentTextField;
    private JTextField TeacherNameTextField;
    private JButton sortByDepartmentButton;
    private JButton sortByGroupButton;
    public JPanel mainPanel;

    StudentCollection collection = new StudentCollection();

    public StudentForm() {

        for(int i = 1; i <= 12; i ++) {
            MarkComboBox.addItem(i);
        }

        sortByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.sortById();
            }
        });

        sortByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.sortByFirstName();
            }
        });

        sortByCourierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.sortByLastName();
            }
        });
        sortByDepartmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.sortByDepartment();
            }
        });
        sortByGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.sortByGroup();
            }
        });

        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!FirstNameTextField.getText().isEmpty() &&
                        !LastNameTextField.getText().isEmpty() &&
                        !DepartmentTextField.getText().isEmpty() &&
                        !GroupSpinner.getValue().toString().isEmpty() &&
                        Integer.parseInt(GroupSpinner.getValue().toString()) > 0){
                    Student student = new Student(FirstNameTextField.getText(),
                            LastNameTextField.getText(),
                            Integer.parseInt(GroupSpinner.getValue().toString()),
                            DepartmentTextField.getText());

                    if (!DisciplineTextField.getText().isEmpty()){
                        student.setDiscipline(DisciplineTextField.getText());
                    }
                    if (!MarkComboBox.getSelectedItem().toString().isEmpty()){
                        student.setMark(Integer.parseInt(MarkComboBox.getSelectedItem().toString()));
                    }
                    if (!TeacherNameTextField.getText().isEmpty()){
                        student.setTeacherName(TeacherNameTextField.getText());
                    }
                    collection.addStudent(student);
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame,
                            student.toString() + " was added!",
                            "Successful",
                            JOptionPane.PLAIN_MESSAGE);
//                    NameTextField.setText("");
//                    CourierTextField.setText("");
//                    DataTimeTextField.setText("");
                } else {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame,
                            "Please check the correctness of filling in the field!!!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        showCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, collection.toString(),
                        "Collection of order",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.printInFile();
            }
        });

        serializableCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fileInputStream = new FileInputStream( nameOfFile );
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                    StudentCollection studentCollection = (StudentCollection) objectInputStream.readObject();
                    OrderCollection orderCollection = (OrderCollection) objectInputStream.readObject();
                    ContactCollection contactCollection = (ContactCollection) objectInputStream.readObject();
                    CloseContactCollection closeContactCollection = (CloseContactCollection) objectInputStream.readObject();

                    objectInputStream.close();
                    fileInputStream.close();

                    FileOutputStream fileOutputStream = new FileOutputStream( nameOfFile );
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                    objectOutputStream.writeObject(collection);
                    objectOutputStream.writeObject(orderCollection);
                    objectOutputStream.writeObject(contactCollection);
                    objectOutputStream.writeObject(closeContactCollection);

                    objectOutputStream.close();
                    objectOutputStream.close();

                } catch (IOException | ClassNotFoundException exception) {
                    exception.printStackTrace();
                }
            }
        });

        deserializableCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream fileInputStream = new FileInputStream( nameOfFile );
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                    collection = (StudentCollection) objectInputStream.readObject();
                    OrderCollection orderCollection = (OrderCollection) objectInputStream.readObject();
                    ContactCollection contactCollection = (ContactCollection) objectInputStream.readObject();
                    CloseContactCollection closeContactCollection = (CloseContactCollection) objectInputStream.readObject();
                    objectInputStream.close();
                } catch (IOException | ClassNotFoundException exception) {
                    exception.printStackTrace();
                }
            }
        });

    }
}
