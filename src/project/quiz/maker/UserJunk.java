
package project.quiz.maker;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"junkID"})
public class UserJunk {
    private int junkID;

    public UserJunk () {
    }

    public int getJunkID () {
        return junkID;
    }

    public void setJunkID ( int junkID ) {
        this.junkID = junkID;
    }
}
