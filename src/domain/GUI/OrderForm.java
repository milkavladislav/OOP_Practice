package domain.GUI;

import domain.Classes.Order;
import domain.Collections.CloseContactCollection;
import domain.Collections.ContactCollection;
import domain.Collections.OrderCollection;
import domain.Collections.StudentCollection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class OrderForm {
    private final  String nameOfFile = "collections.txt";

    public JPanel mainPanel;
    private JTextField NameTextField;
    private JButton addOrderButton;
    private JButton sortByNameButton;
    private JButton sortByIdButton;
    private JTextField CourierTextField;
    private JTextField DataTimeTextField;
    private JTextField TypeTextField;
    private JButton sortByCourierButton;
    private JButton showCollectionButton;
    private JButton saveToFileButton;
    private JButton serializableCollectionButton;
    private JButton deserializableCollectionButton;
    private JComboBox TypeComboBox;

    private OrderCollection collection = new OrderCollection();
    public OrderForm() {

        TypeComboBox.addItem("Rush order");
        TypeComboBox.addItem("Not rush order");


        sortByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.sortById();
            }
        });

        sortByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.sortByName();
            }
        });

        sortByCourierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collection.sortByCourier();
            }
        });

        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!NameTextField.getText().isEmpty() && !CourierTextField.getText().isEmpty()){
                    Order order = new Order(NameTextField.getText(), CourierTextField.getText());

                    if (!DataTimeTextField.getText().isEmpty()){
                        order.setDateTime(DataTimeTextField.getText());
                    }
                    if (!TypeComboBox.getSelectedItem().toString().isEmpty()){
                        order.setType(TypeComboBox.getSelectedIndex() + 1);
                    }
                    collection.addOrder(order);
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame,
                            order.toString() + " was added!",
                            "Successful",
                            JOptionPane.PLAIN_MESSAGE);
                    NameTextField.setText("");
                    CourierTextField.setText("");
                    DataTimeTextField.setText("");
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

                    objectOutputStream.writeObject(studentCollection);
                    objectOutputStream.writeObject(collection);
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

                    StudentCollection studentCollection = (StudentCollection) objectInputStream.readObject();
                    collection = (OrderCollection) objectInputStream.readObject();
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
