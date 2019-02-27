package project.quiz.maker;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Iterator;

import java.util.LinkedList;

@JsonPropertyOrder({"collectionID","collectionName","questionList","totalQuestion"})
public class Collection {
    
    private int collectionID;
    private String collectionName;
    private LinkedList<Question> questionList;
    private int totalQuestion;

    public Collection() {
        questionList = new LinkedList<> ();
    }

    public Collection(String collectionName) {
        this ();
        this.collectionName = collectionName;
    }
    
    public Collection(int collectionID, String collectionName) {
        this (collectionName);
        this.collectionID = collectionID;
    }
    
    public void setCollectionID(int collectionID) {
        this.collectionID = collectionID;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
    
    
    public void setQuestionList ( LinkedList<Question> questionList ) {
        this.questionList = questionList;
    } 
    
    public void setTotalQuestion ( int totalQuestion ) {
        this.totalQuestion = totalQuestion;
    }
    
    public int getCollectionID() {
        return collectionID;
    }
    
    public String getCollectionName() {
        return collectionName;
    }
    
    public LinkedList<Question> getQuestionList () {
        return questionList;
    }

    public int getTotalQuestion () {
        return totalQuestion;
    }
    
    public void addQuestion(String question, LinkedList<Answer> answers, boolean hasMultipleAnswer) {
        questionList.add(new Question (question, answers, hasMultipleAnswer));
        totalQuestion++;
    }
    
    public void addQuestion(Question question) {
        questionList.add(question);
        totalQuestion++;
    }
}
