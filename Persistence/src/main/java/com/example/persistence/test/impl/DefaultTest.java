package com.example.persistence.test.impl;

import com.example.persistence.test.Test;

public class DefaultTest implements Test {
    private int numberOfQuestions;


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
}
