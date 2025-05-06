package org.example.gui;

import org.example.model.Customer;
import org.example.service.Auth;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends Base {
    private JTextField txtEmail;
    private JPanel panel1;
    private JButton loginButton;
    private JButton registerButton;
    private JPasswordField txtPass;

    public Login() {
        super("Login");
        add(panel1);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText().trim();
                String password = new String(txtPass.getPassword());

                System.out.println(email + " " + password);

                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1,
                            "mail ve sifre gir",
                            "Uyarı",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    Customer customer = Auth.validateLogin(email, password);
                    System.out.println(customer);

                    if (customer != null) {

                        if (customer.getType() == 0) {
                            NavigationManager.showHomeAdminForm();
                        } else if (customer.getType() == 1) {
                            NavigationManager.showHomeUserForm();
                        }
                    } else {
                        JOptionPane.showMessageDialog(panel1,
                                "email veya sifre hatali",
                                "Hata",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel1,
                            "server errır: " + ex.getMessage(),
                            "Hata",
                            JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationManager.showAddCustomerForm();
            }
        });
    }
}