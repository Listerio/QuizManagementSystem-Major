package com.example.persistence.test.impl;

import com.example.persistence.test.Test;

public class DefaultTest implements Test {
    private int numberOfQuestions;
    private int timer;


    public DefaultTest(int numberOfQuestions){
        this.numberOfQuestions=numberOfQuestions;

    }

    public DefaultTest(){


    }

    @Override
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions=numberOfQuestions;
    }

    @Override
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    @Override
    public int getTimer() {
        return timer;
    }

    @Override
    public void setTimer(int timer) {
        this.timer=timer;
    }
}
