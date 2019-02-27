
package project.quiz.maker;

public interface AcquireableJunkData {
    
    boolean hasFileExisted();
    
    Object fetchJunkData();
    
    void commitJunkData(Object obj);
}
