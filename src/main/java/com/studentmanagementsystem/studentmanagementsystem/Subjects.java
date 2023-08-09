package com.studentmanagementsystem.studentmanagementsystem;

import javafx.scene.control.Button;

public class Subjects {
    private String subject;
    private Button data;
    private Button ass;
    public Subjects() {
    }

    public Subjects(String subject, Button data, Button ass) {
        this.subject = subject;
        this.data = data;
        this.ass = ass;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public Button getData() {
        return data;
    }

    public Button getAss() {
        return ass;
    }
}
