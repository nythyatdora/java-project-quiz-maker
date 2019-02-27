
package project.quiz.maker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CollectionJunkData implements AcquireableJunkData {
    
    private final String COLLECTION_JUNK_FILE = "collection-junk.txt";
    
    public static CollectionJunkData createInstance() {
        return new CollectionJunkData ();
    }

    private void constructDefaultJunk() throws IOException {
        ObjectMapper mapper = new ObjectMapper ();    
        
        CollectionJunk junk = new CollectionJunk ();
        junk.setJunkID (2);

        mapper.writeValue (new File (COLLECTION_JUNK_FILE), junk);
    }
    
    @Override
    public boolean hasFileExisted () {
        boolean hasExisted = false;
        
        File file = new File (COLLECTION_JUNK_FILE);
        // check if file exist
        if (!file.exists ()) {
            try {
                constructDefaultJunk ();
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
    public Object fetchJunkData () {
        Object obj = null;
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            obj = mapper.readValue(new File(COLLECTION_JUNK_FILE), new TypeReference<CollectionJunk>(){});
        }
        catch(IOException ex) {
            Logger.getLogger (DialogLogin.class.getName()).log (Level.SEVERE, null, ex);
        }
        
        return obj;
    }

    @Override
    public void commitJunkData ( Object obj ) {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            mapper.writeValue (new File(COLLECTION_JUNK_FILE), obj);
        }
        catch (IOException ex) {
            Logger.getLogger (DialogLogin.class.getName()).log (Level.SEVERE, null, ex);
        }
    }
}
