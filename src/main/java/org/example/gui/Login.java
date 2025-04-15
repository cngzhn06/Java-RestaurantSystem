package org.example.gui;

import org.example.service.DBConnection;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

            if (validateLogin(email, password)) {
                NavigationManager.showHomeForm();
            } else {
                JOptionPane.showMessageDialog(null,
                        "email and pass error",
                        "Hata",
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

    private boolean validateLogin(String email, String password) {
        String query = "SELECT COUNT(*) FROM customer WHERE email = ? AND password = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "login error",
                    "err",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        return false;
    }
}
