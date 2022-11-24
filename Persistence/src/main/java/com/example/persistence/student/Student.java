package com.example.persistence.student;
public class Student {

    private String examNumber;
    private String password;
    private String imageIcon;


    public String getPassword() {
        return password;
    }

    public String getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber;
    }

    public String getImageIcon() {
        return imageIcon;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImageIcon(String imageIcon) {
        this.imageIcon = imageIcon;
    }

}

