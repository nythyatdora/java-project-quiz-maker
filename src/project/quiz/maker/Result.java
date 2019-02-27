
package project.quiz.maker;

public class Result {
    private final int totalQuestion;
    private final int totalCorrect;
    private final int totalIncorrect;
    private final double averageSpeed;

    public Result ( int totalQuestion, int totalCorrect, int totalIncorrect, double averageSpeed ) {
        this.totalQuestion = totalQuestion;
        this.totalCorrect = totalCorrect;
        this.totalIncorrect = totalIncorrect;
        this.averageSpeed = averageSpeed;
    }

    public int getTotalQuestion () {
        return totalQuestion;
    }

    public int getTotalCorrect () {
        return totalCorrect;
    }

    public int getTotalIncorrect () {
        return totalIncorrect;
    }

    public double getAverageSpeed () {
        return averageSpeed;
    }      
}
