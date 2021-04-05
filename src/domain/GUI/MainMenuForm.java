package domain.GUI;

import domain.Collections.CloseContactCollection;
import domain.Collections.ContactCollection;
import domain.Collections.OrderCollection;
import domain.Collections.StudentCollection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuForm {
    public JPanel mainPanel;
    private JButton contactButton;
    private JButton closeContactButton;
    private JButton orderButton;
    private JButton studentButton;

    private ContactCollection contactCollection = new ContactCollection();
    private CloseContactCollection closeContactCollection = new CloseContactCollection();
    private OrderCollection orderCollection = new OrderCollection();
    private StudentCollection studentCollection = new StudentCollection();

    private void SettingForm(JFrame form, java.awt.Container panel){
        form.setContentPane(panel);
        form.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        form.pack();
        form.setVisible(true);
        form.setBounds(250,300,600,500);
    }

    public MainMenuForm() {
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame form = new JFrame("ORDER");
                SettingForm(form, new OrderForm().mainPanel);
            }
        });

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame form= new JFrame("STUDENT");
                SettingForm(form, new StudentForm().mainPanel);
            }
        });

        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame form = new JFrame("CONTACT");
                SettingForm(form, new ContactForm().mainPanel);
            }
        });

        closeContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame form = new JFrame("CLOSE CONTACT");
                SettingForm(form, new CloseContactForm().mainPanel);
            }
        });
    }


}
