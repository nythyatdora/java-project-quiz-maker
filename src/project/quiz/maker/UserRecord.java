package project.quiz.maker;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"totalQuestion", "totalCorrect", "totalIncorrect", "averageSpeed", "recentRecord"})
public class UserRecord {
    private int totalQuestion;
    private int totalCorrect;
    private int totalIncorrect;
    private double averageSpeed;
    private String recentRecord;

    public UserRecord () {
        recentRecord = "0/0";
    }

    public UserRecord ( int totalQuestion, int totalCorrect, int totalIncorrect, double averageSpeed) {
        this.totalQuestion = totalQuestion;
        this.totalCorrect = totalCorrect;
        this.totalIncorrect = totalIncorrect;
        this.averageSpeed = averageSpeed;
        this.recentRecord = "0/0";
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }
    
    public int getTotalCorrect() {
        return totalCorrect;
    }
    
    public int getTotalIncorrect() {
        return totalIncorrect;
    }
    
    public double getAverageSpeed() {
        return averageSpeed;
    }
    
    public String getRecentRecord() {
        return recentRecord;
    }
    
    public void setTotalIncorrect() {
        this.totalIncorrect = totalQuestion - totalCorrect;
    }
    
    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
    
    public void setRecentRecord(String recentRecord) {
        this.recentRecord = recentRecord;
    }
    
    public void increaseTotalQuestion(int value) {
        this.totalQuestion = this.totalQuestion + value;
    }
    
    public void increaseTotalCorrect(int value) {
        this.totalCorrect = this.totalCorrect + value;
    }
}
