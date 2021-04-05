package domain.GUI;

import domain.Classes.Contact;
import domain.Collections.CloseContactCollection;
import domain.Collections.ContactCollection;
import domain.Collections.OrderCollection;
import domain.Collections.StudentCollection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ContactForm {
    private final  String nameOfFile = "collections.txt";

    private JTextField FirstNameTextField;
    private JTextField AddressTextField;
    private JButton addContactButton;
    private JButton sortByFirstNameButton;
    private JButton sortByIdButton;
    private JButton sortByLastNameButton;
    private JButton showCollectionButton;
    private JButton saveToFileButton;
    private JButton serializableCollectionButton;
    private JButton deserializableCollectionButton;
    private JTextField LastNameTextField;
    public JPanel mainPanel;

    private ContactCollection collection = new ContactCollection();
    public ContactForm() {
        sortByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.sortById();
            }
        });

        sortByFirstNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.sortByFirstName();
            }
        });

        sortByLastNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.sortByLastName();
            }
        });

        addContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!FirstNameTextField.getText().isEmpty() && !LastNameTextField.getText().isEmpty() && !AddressTextField.getText().isEmpty()){

                    Contact contact = new Contact(FirstNameTextField.getText(), LastNameTextField.getText(), AddressTextField.getText());

                    collection.addContact(contact);
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame,
                            contact.toString() + " was added!",
                            "Successful",
                            JOptionPane.PLAIN_MESSAGE);
                    FirstNameTextField.setText("");
                    LastNameTextField.setText("");
                    AddressTextField.setText("");
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
                        "Collection of contact",
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

                    objectOutputStream.writeObject(studentCollection);
                    objectOutputStream.writeObject(orderCollection);
                    objectOutputStream.writeObject(collection);
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

                    StudentCollection studentCollection = (StudentCollection) objectInputStream.readObject();
                    OrderCollection orderCollection = (OrderCollection) objectInputStream.readObject();
                    collection = (ContactCollection) objectInputStream.readObject();
                    CloseContactCollection closeContactCollection = (CloseContactCollection) objectInputStream.readObject();
                    objectInputStream.close();
                } catch (IOException | ClassNotFoundException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
