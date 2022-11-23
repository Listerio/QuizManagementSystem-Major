package com.example.persistence;

import com.example.persistence.dao.SubjectDao;
import com.example.persistence.dao.TestDao;
import com.example.persistence.scorrer.Scorrer;
import com.example.persistence.subject.Subject;
import com.example.persistence.test.CreateTest;
import com.example.persistence.test.Test;
import com.example.persistence.test.impl.DefaultTest;

import java.sql.SQLException;


public class Demo {
    public static void main(String[] args) throws SQLException {
        Test test1=new DefaultTest(1);
        Subject s= new Subject("math101");
        CreateTest test=new CreateTest(s,test1);
        test.createQuestion();
        Scorrer scorrer=new Scorrer(test1);
        System.out.println();
        System.out.println();
        String ans = null;
        SubjectDao dao=new SubjectDao();
        TestDao dao1=new TestDao();

        dao1.setQuestions(test, dao.getId(s));


        //int i=0;
        //   System.out.println("Student Section");
//        for (Question q: test.showQuestion()) {
//            i++;
//            System.out.println("Question "+i);
//            System.out.println(q.toString());
//            Scanner sc=new Scanner(System.in);
//            boolean a=true;
//            while (a) {
//                a=false;
//                System.out.println("enter answer");
//                String answer= q.getAnswer();
//                ans = sc.nextLine();
//                switch (ans){
//                    case "a": ans=q.getOption1();
//                        break;
//                    case "b": ans= q.getOption2();
//                        break;
//                    case "c": ans= q.getOption3();
//                        break;
//                    case "d": ans= q.getOption4();
//                        break;
//                    default:
//                        System.out.println("input correct option");
//                        a=true;
//                }
//            }
//            scorrer.isCorrect(ans.equals(q.getAnswer()));
//        }
//        System.out.println(scorrer.getPercentage()+" %");
//
    }
}
