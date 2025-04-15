package org.example.gui;

import org.example.model.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.service.Auth.validateLogin;


public class Login extends Base {
    private JTextField txtEmail;
    private JPanel panel1;
    private JButton loginButton;
    private JButton registerButton;
    private JPasswordField txtPass;

    public Login() {
        super("Login");
        add(panel1);

        loginButton.addActionListener(e -> {
            String email = txtEmail.getText();
            String password = new String(txtPass.getPassword());

            Customer customer = validateLogin(email, password);

            if (customer != null) {
                if (customer.getType() == 0) {
                    NavigationManager.showHomeAdminForm(customer);
                } else if (customer.getType() == 1) {
                    NavigationManager.showHomeUserForm(customer);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Invalid email or password",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
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