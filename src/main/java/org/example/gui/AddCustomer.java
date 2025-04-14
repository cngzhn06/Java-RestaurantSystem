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

    private void clearField() {
        txtPhone.setText("");
        txtMail.setText("");
        txtSName.setText("");
        txtName.setText("");
        txtTC.setText("");
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

                    String phoneRegex = "^[0-9]+$";
                    boolean isPhoneValid = phone.matches(phoneRegex);
                    boolean isMailValid = mail.contains("@");

                    if (!isPhoneValid || !isMailValid || TC.length() != 11) {
                        StringBuilder errorMessage = new StringBuilder();
                        if (!isPhoneValid) {
                            errorMessage.append("Telefon hatalı.\n");
                        }
                        if (TC.length() != 11){
                            errorMessage.append("TC Hatalı \n");
                        }
                        if (!isMailValid) {
                            errorMessage.append("Mail hatalı.");
                        }
                        JOptionPane.showMessageDialog(panel1,
                                errorMessage.toString(),
                                "Hata",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Customer newCustomer = new Customer(name, surName, phone, mail,TC);
                    customerDAO.addCustomer(newCustomer);
                    clearField();
                    JOptionPane.showMessageDialog(panel1,
                            "Müşteri başarıyla eklendi",
                            "Başarılı",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel1,
                            "Bir hata oluştu: " + ex.getMessage(),
                            "Hata",
                            JOptionPane.ERROR_MESSAGE);
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
