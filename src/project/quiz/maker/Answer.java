package project.quiz.maker;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"answerNO", "answerDetail", "isChosen"})
public class Answer {

    private int answerNO;
    private String answerDetail;
    private boolean isChosen;

    public Answer () {
    }

    public Answer ( String answer, boolean isChosen ) {
        this.answerDetail = answer;
        this.isChosen = isChosen;
    }

    public Answer ( int answerNO, String answer, boolean isChosen ) {
        this (answer, isChosen);
        this.answerNO = answerNO;
    }

    public int getAnswerNO () {
        return answerNO;
    }

    public String getAnswerDetail () {
        return answerDetail;
    }

    public boolean getIsChosen () {
        return isChosen;
    }

    public void setAnswerDetail ( String answerDetail ) {
        this.answerDetail = answerDetail;
    }

    public void setIsChosen ( boolean isChosen ) {
        this.isChosen = isChosen;
    }

    public void setAnswerNO ( int answerNO ) {
        this.answerNO = answerNO;
    }
}
