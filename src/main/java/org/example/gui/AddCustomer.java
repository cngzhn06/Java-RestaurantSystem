package org.example.gui;

import org.example.service.CommandProcessor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddCustomer extends Base {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton addButton;
    private JButton backButton;

    private void clearField() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
    }

    public AddCustomer() {
        super("Restoran Sistemi");
        add(panel1);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = textField1.getText();
                    String surname = textField2.getText();
                    String phone = textField3.getText();
                    String mail = textField4.getText();


//                    String regex = "^[0-9]+$";
//                    boolean isPhoneValid = phone.matches(regex);
//                    boolean isMailValid = mail.contains("@");
                    CommandProcessor.addCustomer(name, surname, phone, mail);
                    clearField();

//                    if (!isMailValid) {
//                        JOptionPane.showMessageDialog(panel1, "telefon veya mail hatalı", "Hata", JOptionPane.ERROR_MESSAGE);
//                        System.out.println("!ismailvalid");
//                    } else {
//                    CommandProcessor.addCustomer(name, surname, phone, mail);
//                    clearField();
//                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButton();
            }
        });
    }
}
