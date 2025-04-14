package org.example.model;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    public String TC;

    public Customer( String firstName, String lastName, String phone, String email, String TC) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.TC = TC;
    }

    public String getTC() {
        return TC;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId(){
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName + " " + phone + " " + email + " " + TC;
    }
}
