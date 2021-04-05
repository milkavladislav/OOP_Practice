package Test;

import domain.GUI.MainMenuForm;


import javax.swing.*;


public class Main {

    
    public static void main(String[] args) {
        final  String nameOfFile = "collections.txt";
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream( nameOfFile );
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//
//            StudentCollection studentCollection = new StudentCollection();
//            studentCollection.addStudent(new Student("Vlad", "Milka", 34, "Math"));
//            objectOutputStream.writeObject(studentCollection);
//            OrderCollection orderCollection = new OrderCollection();
//            orderCollection.addOrder(new Order("FirstOrder", "Dima"));
//            objectOutputStream.writeObject(orderCollection);
//            ContactCollection contactCollection = new ContactCollection();
//            contactCollection.addContact(new Contact("Vlad", "Milka", "Poltava"));
//            objectOutputStream.writeObject(contactCollection);
//            CloseContactCollection closeContactCollection = new CloseContactCollection();
//            closeContactCollection.addContact(new CloseContact("Vlad", "Milka", "Poltava", "06.06.2003", "Father"));
//            objectOutputStream.writeObject(closeContactCollection);
//
//            objectOutputStream.close();
//            objectOutputStream.close();
//
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }


        JFrame mainWindow = new JFrame("PRACTICE OOP");
        mainWindow.setContentPane(new MainMenuForm().mainPanel);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setVisible(true);
        mainWindow.setBounds(200,200,400,300);



    }
    
}
