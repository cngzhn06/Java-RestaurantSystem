package org.example.gui;

import org.example.service.CommandProcessor;
import org.example.service.DataLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer extends JFrame{

    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton ekleButton;

    private void clearField(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
    }

    public AddCustomer(){
        add(panel);
        setSize(500,300);
        setTitle("Restoran Sistemi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String name = textField1.getText();
                    String surname = textField2.getText();
                    String phone = textField3.getText();
                    String mail =textField4.getText();
                    int id = 2;

                    String[] command = {"ADDCUSTOMER" , String.valueOf(id),name,surname,phone,mail};

                    CommandProcessor.addCustomer(command);

                    clearField();

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }
}
