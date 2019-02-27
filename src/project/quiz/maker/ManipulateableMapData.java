
package project.quiz.maker;

public interface ManipulateableMapData {
    boolean insertData(String data);
    
    boolean updateData(int id, String data, String newData);
    
    boolean removeData(int id, String data);
}
