package org.example.gui;

public class NavigationManager {
    private static Home homeForm;
    private static AddCustomer addCustomerForm;
    private static ListCustomer listCustomerForm;

    public static void showHomeForm(){
        if (homeForm == null){
            homeForm = new Home();
        }
        hideAllForms();
        homeForm.showForm();
    }
    public static void showAddCustomerForm(){
        if (addCustomerForm == null){
            addCustomerForm = new AddCustomer();
        }
        hideAllForms();
        addCustomerForm.showForm();
    }

    public static void showListCustomerForm(){
        if (listCustomerForm == null){
            listCustomerForm = new ListCustomer();
        }
        hideAllForms();
        listCustomerForm.showForm();
    }

    public static void hideAllForms() {
        if (homeForm != null) {
            homeForm.hideForm();
        }
        if (addCustomerForm != null) {
            addCustomerForm.hideForm();
        }
        if (listCustomerForm != null) {
            listCustomerForm.hideForm();
        }
    }

}
