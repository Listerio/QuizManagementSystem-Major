package com.example.persistence.subject;

public class Subject {
    String subjectName;
    private static int idCounter;
    private int id;
    {
        idCounter++;
        id=idCounter;
    }
    public Subject(){

    }
    public Subject(String subjectName){
        this.subjectName=subjectName;
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

}
