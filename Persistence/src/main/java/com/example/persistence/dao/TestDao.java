package com.example.persistence.dao;

import com.example.persistence.question.Question;
import com.example.persistence.question.impl.DefaultQuestion;
import com.example.persistence.test.CreateTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
    private String query;

    public void setQuestions(CreateTest test, int subjectId) throws SQLException {
        query = "INSERT INTO `quiz`.`question` (`id_question`, `question`, `option1`, `option2`," +
                " `option3`, `option4`, `answer`, `subject_id`) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            for (Question q : test.getQuestionStream()) {
                statement.setInt(1, q.getQuestionId());
                statement.setString(2, q.getQuestion());
                statement.setString(3, q.getOption1());
                statement.setString(4, q.getOption2());
                statement.setString(5, q.getOption3());
                statement.setString(6, q.getOption4());
                statement.setInt(7, subjectId);
                statement.executeUpdate();
            }
        }
    }

    public List<Question> getQuestions(int SubjectId) throws SQLException {
        List<Question> questions = new ArrayList<>();
        Question question;
        query = "Select * from quiz.question";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet set = statement.executeQuery()) {
                while (set.next()) {
                    question = new DefaultQuestion();
                    question.setQuestion(set.getString("question"));
                    question.setOption1(set.getString("option1"));
                    question.setOption2(set.getString("option2"));
                    question.setOption3(set.getString("option3"));
                    question.setOption4(set.getString("option4"));
                    question.setAnswer(set.getString("answer"));
                    questions.add(question);
                }
            }
        }
        return questions;
    }

}
