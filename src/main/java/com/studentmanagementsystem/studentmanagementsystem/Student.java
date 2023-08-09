package com.studentmanagementsystem.studentmanagementsystem;

import java.util.ArrayList;

public class Student extends Person {
    private String grade;
    private double degree;
    private int id;
    private String department;
    private boolean attendance;
    private ArrayList<String> subjects = new ArrayList<>();
    public Student(){}
    public Student(String firstName, String secondName, String grade, int id,
                   String department, String email,String password)
    {
        super(firstName, secondName);
        setLogInfo(userName,password);
        this.grade = grade;
        this.id = id;
        this.department = department;
        this.setEmail(email);
    }    public Student(String firstName, String secondName,String username, String grade, int id,
                        String department, String email,String password)
    {
        super(firstName, secondName);
        setLogInfo(userName,password);
        this.grade = grade;
        this.id = id;
        this.department = department;
        this.setEmail(email);
    }

    public String getName() {
        return " " + this.firstName + " " + this.secondName;
    }

    public String getGrade() {
        return this.grade;
    }



    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getDegree() {
        return this.degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public long getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<String> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }
    public void clearData () {
        this.firstName = "";
        this.secondName = "";
        this.id =  0 ;
        this.setEmail("");
        this.grade = "";
        this.password = "";
        this.degree = 0 ;
        this.userName = "" ;
        this.department = "";
        this.subjects = null;
        this.gender = "";
        this.setUserName("");
    }
    public void setAllData (String fstName,String scndName,String username,String password,
                            String email,String gender,double age,int id,String grade) {
        this.firstName = fstName;
        this.secondName = scndName;
        this.userName = username;
        this.password = password;
        this.setEmail(email);
        this.gender = gender;
        this.setAge(age);
        this.id = id;
        this.grade = grade;
    }

    public boolean getAttendance() {
        return this.attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }
}