
package project.quiz.maker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserData implements AcquireableMapData, TestableUserData {
    
    private final String USER_FILE = "user.txt";
    
    public static UserData createInstance() {
        return new UserData ();
    }
        
    private void constructDefaultAccount() throws IOException {
        ObjectMapper mapper = new ObjectMapper ();    
        
        TreeMap<Integer, User> map = new TreeMap<> ();
        User defaultAccount = new User(0,"admin", "password");
        
        map.put (defaultAccount.getUserID (), defaultAccount);
        
        mapper.writeValue (new File (USER_FILE), map);
    }
    
    @Override
    public boolean hasFileExisted () {
        boolean hasExisted = false;
        
        File file = new File (USER_FILE);
        // check if file exist
        if (!file.exists ()) {
            try {
                constructDefaultAccount ();
            }
            catch ( IOException ex ) {
                Logger.getLogger (DialogLogin.class.getName()).log (Level.SEVERE, null, ex);
            }
        }
        else 
            return hasExisted == true;
        
        return hasExisted;
    }

    @Override
    public TreeMap fetchMapData () {
        TreeMap<Integer, User> map = null;
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            map = mapper.readValue(new File(USER_FILE), new TypeReference<TreeMap<Integer, User>>(){});
        }
        catch(IOException ex) {
            Logger.getLogger (DialogLogin.class.getName()).log (Level.SEVERE, null, ex);
        }
        
        return map;
    }

    @Override
    public void commitMapData ( Map map, String message ) {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            mapper.writeValue (new File(USER_FILE), map);

            MessageBox.showMessage (null, message);
        }
        catch (IOException ex) {
            Logger.getLogger (DialogLogin.class.getName()).log (Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean hasFieldExisted (Map map, String fieldValue) {
        TreeMap<Integer, User> treeMap = (TreeMap<Integer, User>) map;
        for ( Map.Entry<Integer, User> entry : treeMap.entrySet () ) {
            User value = entry.getValue ();
            if(value.getUsername ().equals (fieldValue)) {
                return true;
            }
        }
        return false;
    }
}
