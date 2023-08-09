package com.studentmanagementsystem.studentmanagementsystem;

public class Person {
    private String name;
    protected String firstName;
    protected String secondName;
    protected String userName;
    protected String password;
    protected String gender;
    private String address;
    private Double age;
    private String nationality;
    private String email;

    public Person() {
    }

    public Person(String firstName, String secondName)
    {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public void setLogInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public void setAge(Double age) {
        this.age = age;
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}