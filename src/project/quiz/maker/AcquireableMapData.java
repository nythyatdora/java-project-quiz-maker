
package project.quiz.maker;

import java.util.Map;

public interface AcquireableMapData {
    
    boolean hasFileExisted();
    
    Map fetchMapData();
    
    void commitMapData(Map map, String message);
}
