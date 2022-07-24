package com.example.designmode.prototype;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;

@Data
public class QuestionBank implements Cloneable{
    private String candidate;
    private String number;
    private ArrayList<AnswerQuestion> answerQuestions = new ArrayList<>();
    private ArrayList<ChoiceQuestion> choiceQuestions = new ArrayList<>();

    public QuestionBank appendChoiceQuestion(ChoiceQuestion choiceQuestion){
        choiceQuestions.add(choiceQuestion);
        return this;
    }

    public QuestionBank appendAnswerQuestion(AnswerQuestion answerQuestion){
        answerQuestions.add(answerQuestion);
        return this;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        QuestionBank questionBank = (QuestionBank) super.clone();
        questionBank.choiceQuestions = (ArrayList<ChoiceQuestion>) choiceQuestions.clone();
        questionBank.answerQuestions = (ArrayList<AnswerQuestion>) answerQuestions.clone();
        //将题重排
        Collections.shuffle(questionBank.choiceQuestions);
        Collections.shuffle(questionBank.answerQuestions);
        //将题的答案重排
        for (ChoiceQuestion choiceQuestion : questionBank.choiceQuestions) {
            Topic random = RandomUtils.random(choiceQuestion.getOption(), choiceQuestion.getKey());
            choiceQuestion.setOption(random.getOption());
            choiceQuestion.setKey(random.getKey());
        }
        return questionBank;
    }
}
