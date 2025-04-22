package org.example.gui;

import org.example.model.Customer;

public class NavigationManager {
    private static HomeAdmin homeAdminForm;
    private static AddCustomer addCustomerForm;
    private static ListCustomer listCustomerForm;
    private static SearchRestaurant searchRestaurantForm;
    private static ListRestaurant listRestaurantForm;
    private static Login loginForm;
    private static HomeUser homeUserForm;


    public static void showHomeAdminForm(Customer customer) {

        if (homeAdminForm == null) {
            homeAdminForm = new HomeAdmin(customer);
        }hideAllForms();
        homeAdminForm.showForm();
        System.out.println("admin: " + customer.getFirstName() + " " + customer.getLastName());
    }

    public static void showHomeUserForm(Customer customer) {
        if (homeUserForm == null) {
            homeUserForm = new HomeUser(customer);
        }hideAllForms();
        homeUserForm.showForm();
        System.out.println("user: " + customer.getFirstName() + " " + customer.getLastName());

    }

    public static void showAddCustomerForm() {
        if (addCustomerForm == null) {
            addCustomerForm = new AddCustomer();
        }
        hideAllForms();
        addCustomerForm.showForm();
    }

    public static void showListCustomerForm() {
        if (listCustomerForm == null) {
            listCustomerForm = new ListCustomer();
        }
        hideAllForms();
        listCustomerForm.showForm();
    }

    public static void showListRestaurantForm() {
        if (listRestaurantForm == null) {
            listRestaurantForm = new ListRestaurant();
        }
        hideAllForms();
        listRestaurantForm.showForm();
    }

    public static void showSearchRestaurantForm() {
        if (searchRestaurantForm == null) {
            searchRestaurantForm = new SearchRestaurant();
        }
        hideAllForms();
        searchRestaurantForm.showForm();
    }

    public static void showLoginForm() {
        if (loginForm == null) {
            loginForm = new Login();
        }
        hideAllForms();
        loginForm.showForm();
    }

    public static void hideAllForms() {
        if (homeAdminForm != null) homeAdminForm.hideForm();
        if (addCustomerForm != null) addCustomerForm.hideForm();
        if (listCustomerForm != null) listCustomerForm.hideForm();
        if (searchRestaurantForm != null) searchRestaurantForm.hideForm();
        if (listRestaurantForm != null) listRestaurantForm.hideForm();
        if (loginForm != null) loginForm.hideForm();
    }
}
