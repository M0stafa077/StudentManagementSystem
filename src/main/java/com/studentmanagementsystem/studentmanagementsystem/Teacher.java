package com.studentmanagementsystem.studentmanagementsystem;

public class Teacher extends Person {
    private String subject;
    public Teacher () {
    }
    public Teacher (String fstName , String scndName) {
        this.firstName = fstName;
        this.secondName = scndName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void clearData () {
        this.firstName = "";
        this.secondName = "";
        this.setEmail(" ");
        this.password = "";
        this.userName = "" ;
        this.gender = "";
        this.setUserName("");
        this.subject="";
    }
}
