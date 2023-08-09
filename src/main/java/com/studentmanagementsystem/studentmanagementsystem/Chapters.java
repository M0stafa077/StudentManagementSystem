package com.studentmanagementsystem.studentmanagementsystem;


import javafx.scene.control.Button;

public class Chapters {
    private String chapters ;
    private Button button;
    public Chapters(){
    }
    public Chapters(String chapters, Button button) {
        this.chapters = chapters;
        this.button = button;
    }
    public String getChapters() {
        return chapters;
    }

    public Button getButton() {
        return button;
    }

    public void setChapters(String chapters) {
        this.chapters = chapters;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}