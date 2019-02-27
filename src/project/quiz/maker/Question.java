package project.quiz.maker;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.LinkedList;
import java.util.Objects;

@JsonPropertyOrder({"questionNO","questionDetail","answerList","hasMultipleAnswer"})
@JsonIgnoreProperties(value = {"getAllChosenNO"}, ignoreUnknown = true)

public class Question {
    private int questionNO;
    private String questionDetail;
    private LinkedList<Answer> answerList;
    private boolean hasMultipleAnswer;
     
    public Question() {
        answerList = new LinkedList<> ();
    }
    
    public Question(String questionDetail, boolean hasMultipleAnswer) {
        this ();
        this.questionDetail = questionDetail;
        this.hasMultipleAnswer = hasMultipleAnswer;
    }
    
    public Question(String questionDetail, LinkedList<Answer> answerList, boolean hasMultipleAnswer) {
        this (questionDetail, hasMultipleAnswer);
        this.answerList = answerList;
    }
    
    public Question(int questionNO, String questionDetail, LinkedList<Answer> answerList, boolean hasMultipleAnswer) {
        this (questionDetail, answerList, hasMultipleAnswer);
        this.questionNO = questionNO;
    }
    
    public Question(Question question) {
        this.questionNO = question.getQuestionNO ();
        this.questionDetail = question.getQuestionDetail ();
        this.answerList = question.getAnswerList ();
        this.hasMultipleAnswer = question.getHasMultipleAnswer ();
    }
    
    public void setQuestionNO ( int questionNO ) {
        this.questionNO = questionNO;
    }
    
    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
    }

    public void setAnswerList ( LinkedList<Answer> answerList ) {
        this.answerList = answerList;
    }

    public void setHasMultipleAnswer ( boolean hasMultipleAnswer ) {
        this.hasMultipleAnswer = hasMultipleAnswer;
    }

    public int getQuestionNO () {
        return questionNO;
    } 
    
    public String getQuestionDetail() {
        return questionDetail;
    }
    
    public LinkedList<Answer> getAnswerList () {
        return answerList;
    }
            
    public boolean getHasMultipleAnswer() {
        return hasMultipleAnswer;
    }
    
    public void addAnswer(String answer, boolean isCorrect) {
        answerList.add (new Answer(answer, isCorrect));
    }
    
    public String getAllChosenNO () {
        LinkedList<Integer> list = new LinkedList<> ();
        
        answerList.stream ().filter ((next) -> (next.getIsChosen ())).forEachOrdered ((next) -> {
            list.add (next.getAnswerNO ());
        });
        return list.toString ();
    }

    @Override
    public int hashCode () {
        int hash = 5;
        hash = 97 * hash + this.questionNO;
        hash = 97 * hash + Objects.hashCode (this.questionDetail);
        hash = 97 * hash + Objects.hashCode (this.answerList);
        hash = 97 * hash + ( this.hasMultipleAnswer ? 1 : 0 );
        return hash;
    }

    @Override
    public boolean equals ( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass () != obj.getClass () ) {
            return false;
        }
        
        final Question other = (Question) obj;
        if ( this.questionNO != other.questionNO ) {
            return false;
        }
        if ( this.hasMultipleAnswer != other.hasMultipleAnswer ) {
            return false;
        }
        if ( !Objects.equals (this.questionDetail, other.questionDetail) ) {
            return false;
        }
        if ( !Objects.equals (this.answerList, other.answerList) ) {
            return false;
        }
        return true;
    } 
}
