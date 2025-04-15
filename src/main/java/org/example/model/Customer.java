package org.example.model;

public class Customer {
    public int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String TC;
    private String password;
    public int type;


    public Customer( String firstName, String lastName, String phone, String email, String TC, String password,int type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.TC = TC;
        this.password = password;
        this.type = type;
    }

    public Customer( String firstName, String lastName, String phone, String email, String TC, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.TC = TC;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getType(){
        return type;
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