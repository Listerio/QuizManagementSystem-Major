package com.example.persistence.test;

import com.example.persistence.question.Question;
import com.example.persistence.question.impl.DefaultQuestion;
import com.example.persistence.subject.Subject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateTest {
        Test test;
       Subject subject;
       Question question;
       private List<Question> questionStream;




       public CreateTest(Subject subject,Test tests){
           question=new DefaultQuestion();
           this.subject=subject;
            this.question.setSubject(subject);
            this.test=tests;
            questionStream=new ArrayList<>();
       }

    public List<Question> getQuestionStream() {
        return questionStream;
    }

    public void createQuestions(String question, String option1, String option2, String option3, String option4, String answer) {
        this.question.setQuestion(question);
        this.question.setOption1(option1);
        this.question.setOption2(option2);
        this.question.setOption3(option3);
        this.question.setOption4(option4);
        this.question.setAnswer(answer);
        questionStream.add(this.question);
        }
    public void createQuestion(){
            while (this.test.getNumberOfQuestions()>questionStream.size()){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Set your Question");
        String question=scanner.nextLine();
        this.question.setQuestion(question);

        System.out.println("Enter option A");
        String option1=scanner.nextLine();
        this.question.setOption1(option1);

        System.out.println("Enter option B");
        String option2=scanner.nextLine();
        this.question.setOption2(option2);


        System.out.println("Enter option C");
        String option3=scanner.nextLine();
        this.question.setOption3(option3);


        System.out.println("Enter option D");
        String option4=scanner.nextLine();
        this.question.setOption4(option4);

        boolean a=true;
        while (a) {
            a=false;
            System.out.println("enter answer");
            System.out.println("input option 'a' if a,'b' if b, 'c' if c, 'd' if d");
            String ans = scanner.nextLine();
            switch (ans){
                case "a": this.question.setAnswer(option1);
                break;
                case "b": this.question.setAnswer(option2);
                break;
                case "c": this.question.setAnswer(option3);
                break;
                case "d": this.question.setAnswer(option4);
                break;
                default:
                    System.out.println("input correct option");
                    a=true;
            }
        }
            questionStream.add(this.question);
            if (this.test.getNumberOfQuestions()==questionStream.size()){
                System.out.println("Questions have been uploaded successfully");
            }
        }
    }

    public List<Question> showQuestion(){
           return questionStream;
    }
    public static ByteArrayOutputStream serializeQuestions(List<Question> empl) {
        try (var byteArrOutputStream = new ByteArrayOutputStream();
             var oos = new ObjectOutputStream(byteArrOutputStream)) {
            oos.writeObject(empl);
            return byteArrOutputStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Question> deserializeQuestions(ByteArrayOutputStream inputStream) {
        try (var ois = new ObjectInputStream(new ByteArrayInputStream(inputStream.toByteArray()))) {
            return (List<Question>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



}
