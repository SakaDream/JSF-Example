package com.sakadream.jsf.bean;

/**
 * Created by Phan Ba Hai on 17/07/2017.
 */
public class Employee {
    private int id;
    private String fullName;
    private String address;
    private String email;
    private String phone;
    private int salary;

    public Employee() {
        this.id = 0;
        this.fullName = "";
        this.address = "";
        this.email = "";
        this.phone = "";
        this.salary = 0;
    }

    public Employee(String fullName, String address, String email, String phone, int salary) {
        this.id = 0;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    public Employee(int id, String fullName, String address, String email, String phone, int salary) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
