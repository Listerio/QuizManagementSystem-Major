package com.example.persistence.scorrer;

import com.example.persistence.test.Test;

public class Scorrer {
    private Test test;
    private boolean[] correctNess;
    private double percentage;
    private int score;
    private int position;
    public Scorrer(Test test){
        position=0;
        this.test=test;
        score=0;
        correctNess=new boolean[this.test.getNumberOfQuestions()];
    }
    void inc(){
        position++;
    }
    public  void isCorrect(boolean val){
        correctNess[position]=val;
        inc();
    }
    public double getPercentage(){
        for (Boolean b:correctNess) {
            if (b){
                score+=1;
            }
        }
        percentage=((double)score/correctNess.length);
        return (percentage*100);
    }
    public int getScore(){
        return score;
    }

}
