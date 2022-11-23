package com.example.persistence.question;

import com.example.persistence.subject.Subject;

public interface Question {
    String toString();
    String getQuestion();
    void setQuestion(String question);
    int getQuestionId();
    String getSubject();
    void  setSubject(Subject subject);

    int getSubjectId();

    void setOption1(String option1);
    void setOption2(String option2);
    void setOption3(String option3);
    void setOption4(String option4);

    String getOption1();
    String getOption2();
    String getOption3();
    String getOption4();

    void setAnswer(String answer);
    String getAnswer();
}
