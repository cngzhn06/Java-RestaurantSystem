package org.example.gui;

import org.example.model.Customer;
import org.example.service.Auth;
import org.example.service.CustomerDAO;

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
                    String phone = txtPhone.getText().trim();
                    String mail = txtMail.getText().trim();
                    String surName = txtSName.getText().trim();
                    String name = txtName.getText().trim();
                    String TC = txtTC.getText().trim();
                    String password = new String(txtPass.getPassword());
                    final int type = 1;

                    if (!isValidInput(phone, mail, TC)) {
                        return;
                    }

                    if (!customerDAO.isUniqueCustomer(mail, phone, TC)) {
                        JOptionPane.showMessageDialog(panel1,
                                "email,phone veya tc kullaniliyor",
                                "Hata",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String hashedPassword = Auth.hashMD5(password);

                    Customer newCustomer = new Customer(name, surName, phone, mail, TC, hashedPassword, type);
                    customerDAO.addCustomer(newCustomer);

                    clearField();
                    JOptionPane.showMessageDialog(panel1,
                            "kayit tamam",
                            "Başarılı",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel1,
                            "Hata: " + ex.getMessage(),
                            "Hata",
                            JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationManager.showLoginForm();
            }
        });
    }

    private boolean isValidInput(String phone, String mail, String TC) {
        boolean isPhoneValid = phone.matches("^[0-9]{10,11}$");

        boolean isMailValid = mail.matches("^[^@]+@[^@]+\\.[^@]+$");

        boolean isTCValid = TC.matches("^[0-9]{11}$");

        if (!isPhoneValid || !isMailValid || !isTCValid) {
            StringBuilder errorMessage = new StringBuilder();
            if (!isPhoneValid) {
                errorMessage.append("- phone number err.\n");
            }
            if (!isMailValid) {
                errorMessage.append("- email err.\n");
            }
            if (!isTCValid) {
                errorMessage.append("- tc err.");
            }

            JOptionPane.showMessageDialog(panel1,
                    errorMessage.toString(),
                    "invalid",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}