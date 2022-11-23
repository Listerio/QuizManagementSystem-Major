package com.example.persistence.question.impl;

import com.example.persistence.question.Question;
import com.example.persistence.subject.Subject;

public class DefaultQuestion implements Question {
    private static int questionCount;
    Subject subject;
    private String subjectName;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private int id;

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public int getQuestionId() {
        return id;
    }

    public void incrQuestionCount() {
        DefaultQuestion.questionCount++;
        this.id=questionCount;
    }

    @Override
    public void setQuestion(String question) {
        this.question=question;
    }

    @Override
    public String getSubject() {
        return null;
    }

    @Override
    public void setSubject(Subject subject) {
        subjectName=subject.getSubjectName();
        this.subject=subject;
    }

    @Override
    public int getSubjectId() {
        return 0;
    }

    @Override
    public void setOption1(String option1) {
       this.option1=option1;
    }

    @Override
    public void setOption2(String option2) {
        this.option2=option2;
    }

    @Override
    public void setOption3(String option3) {
        this.option3=option3;
    }

    @Override
    public void setOption4(String option4) {
        this.option4=option4;
    }

    @Override
    public String getOption1() {
        return option1;
    }

    @Override
    public String getOption2() {
        return option2;
    }

    @Override
    public String getOption3() {
        return option3;
    }

    @Override
    public String getOption4() {
        return option4;
    }

    @Override
    public void setAnswer(String answer) {
        this.answer=answer;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    public String toString(){
        return "Q: "+question+"\n" +
                " a: "+option1+" b: "+option2+"  c:  "+option3+"  d:  "+option4+"\n";
    }


}
