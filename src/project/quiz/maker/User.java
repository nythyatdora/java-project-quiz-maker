package project.quiz.maker;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"userID","username", "password", "recordDetail"})
public class User {
    private int userID;
    private String username;
    private String password;
    private UserRecord recordDetail;
    
    public User () {
        recordDetail = new UserRecord();
    }
    
    public User (String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }
    
    public User (int userID, String username, String password) {
        this(username, password);
        this.userID = userID;
    }
    
    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword () {
        return password;
    }

    public UserRecord getRecordDetail() {
        return recordDetail;
    }
    
    public void setUserID(int id) {
        this.userID = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }
    
    public void setRecordDetail(UserRecord recordDetail) {
        this.recordDetail = recordDetail;
    }
}
