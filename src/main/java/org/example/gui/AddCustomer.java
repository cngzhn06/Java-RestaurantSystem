package org.example.gui;

import org.example.service.CustomerDAO;
import org.example.model.Customer;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer extends Base {
    private JPanel panel1;
    private JTextField txtPhone;
    private JTextField txtMail;
    private JTextField txtSName;
    private JTextField txtName;
    private JButton addButton;
    private JButton backButton;
    private JTextField txtTC;
    private JPasswordField txtPass;

    private void clearField() {
        txtPhone.setText("");
        txtMail.setText("");
        txtSName.setText("");
        txtName.setText("");
        txtTC.setText("");
        txtPass.setText("");
    }

    public AddCustomer() {
        super("Restoran Sistemi");
        add(panel1);

        CustomerDAO customerDAO = new CustomerDAO();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String phone = txtPhone.getText();
                    String mail = txtMail.getText();
                    String surName = txtSName.getText();
                    String name = txtName.getText();
                    String TC = txtTC.getText();
                    String password = new String(txtPass.getPassword());
                    final int type = 0;


                    String phoneRegex = "^[0-9]+$";
                    boolean isPhoneValid = phone.matches(phoneRegex);
                    boolean isAtMailValid = mail.contains("@");
                    boolean isComMailValid = mail.contains(".com");

                    if (!isPhoneValid || !isAtMailValid || TC.length() != 11 || !isComMailValid) {
                        StringBuilder errorMessage = new StringBuilder();
                        if (!isPhoneValid) {
                            errorMessage.append("Telefon hatalı.\n");
                        }
                        if (TC.length() != 11){
                            errorMessage.append("TC Hatalı \n");
                        }
                        if (!isAtMailValid || !isComMailValid) {
                            errorMessage.append("Mail hatalı.");
                        }
                        JOptionPane.showMessageDialog(panel1,
                                errorMessage.toString(),
                                "Hata",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // type değerine vtden 0 ver burada boşuna type değerini ekleme
                    Customer newCustomer = new Customer(name, surName, phone, mail,TC,password,type);
                    customerDAO.addCustomer(newCustomer);
                    clearField();
                    JOptionPane.showMessageDialog(panel1,
                            "Success",
                            "success",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel1,
                            "err: " + ex.getMessage(),
                            "Hata",
                            JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginBack();
            }
        });
    }
}