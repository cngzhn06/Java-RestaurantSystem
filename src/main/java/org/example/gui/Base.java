package org.example.gui;

import javax.swing.*;

import static org.example.gui.NavigationManager.hideAllForms;

public class Base extends JFrame {
    public Base(String title){
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
    }



    public void showForm(){
        setVisible(true);
    }

    public void hideForm(){
        setVisible(false);
    }

    public void backButton(){
        hideAllForms();
        NavigationManager.showHomeForm();
    }
}
