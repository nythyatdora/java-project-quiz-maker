
package project.quiz.maker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CollectionData implements AcquireableMapData, ManipulateableMapData {

    private final CollectionJunkData junkData = CollectionJunkData.createInstance ();
    
    private final String COLLECTION_FILE = "collection.txt";
    
    private final String MESSAGE_WRITE_COLLECTION = "New colletion has been successfully created!";
    private final String MESSAGE_DELETE_COLLECTION = "Selected colletion has been secussfully deleted!";
    private final String MESSAGE_UPDATE_COLLECTION = "Selected colletion has been secussfully updated!";
    
    public static CollectionData createInstance() {
        return new CollectionData ();
    }
    
    private void createDefaultCollection () throws IOException {
        ObjectMapper mapper = new ObjectMapper ();

        LinkedHashMap<Integer, Collection> map = new LinkedHashMap<> ();
        Collection defaultCollection = new Collection (1, "DEFAULT COLLECTION");
        Collection randomCollection = new Collection (2, "RANDOM COLLECTION");

        map.put (defaultCollection.getCollectionID (), defaultCollection);
        map.put (randomCollection.getCollectionID (), randomCollection);

        mapper.writeValue (new File (COLLECTION_FILE), map);
    }
    
    @Override
    public boolean hasFileExisted () {
        boolean hasExisted = false;
        
        File file = new File (COLLECTION_FILE);
        // check if file exist
        if (!file.exists ()) {
            try {
                createDefaultCollection ();
            }
            catch ( IOException ex ) {
                Logger.getLogger (DialogBrowseCollection.class.getName ()).log (Level.SEVERE, null, ex);
            }
        }
        else 
            return hasExisted == true;
        
        return hasExisted;
    }

    @Override
    public Map fetchMapData () {
        LinkedHashMap<Integer, Collection> hashMap = null;
        ObjectMapper mapper = new ObjectMapper ();
        
        // read from file to collection
        try {
            hashMap = mapper.readValue (new File (COLLECTION_FILE), new TypeReference<LinkedHashMap<Integer, Collection>> () {
            });
        }
        catch ( IOException ex ) {
            Logger.getLogger (DialogBrowseCollection.class.getName ()).log (Level.SEVERE, null, ex);
        }
        
        return hashMap;
    }

    @Override
    public void commitMapData ( Map map, String message ) {
        ObjectMapper mapper = new ObjectMapper ();
        // write to file
        try {
            mapper.writeValue (new File (COLLECTION_FILE), map);
            MessageBox.showMessage (null, message);
        }
        catch ( IOException ex ) {
            Logger.getLogger (DialogLogin.class.getName ()).log (Level.SEVERE, null, ex);
        }
    } 
    
    @Override
    public boolean insertData ( String data ) {
        boolean hasInserted = false;
        LinkedHashMap<Integer, Collection> map;

        hasFileExisted ();
        junkData.hasFileExisted ();

        map = (LinkedHashMap<Integer, Collection>) fetchMapData ();
        
        CollectionJunk collectionJunk = (CollectionJunk) junkData.fetchJunkData ();
        collectionJunk.setJunkID (collectionJunk.getJunkID () + 1 ); // check if the increased id has taken
        int id = collectionJunk.getJunkID ();
        
        if(!map.containsKey (id)) {
            // add new collection
            map.put (id, new Collection (id, data));
            hasInserted = true;
        }
        
        if(hasInserted) {
            commitMapData (map, MESSAGE_WRITE_COLLECTION);
            junkData.commitJunkData (collectionJunk);
        }
        return hasInserted;
    }

    @Override
    public boolean updateData (int id, String data, String newData) {
        boolean hasUpdated = false;
        LinkedHashMap<Integer, Collection> map;
            
        hasFileExisted ();
        junkData.hasFileExisted ();

        map = (LinkedHashMap<Integer, Collection>) fetchMapData ();
        
        if(map.containsKey (id)) {
            // update key value to new value
            map.get (id).setCollectionName (newData);
            hasUpdated = true;
        }
        
        if(hasUpdated) {          
            commitMapData (map, MESSAGE_UPDATE_COLLECTION);
        }
        
        return hasUpdated;
    }

    @Override
    public boolean removeData (int id, String data ) {
        boolean hasRemoved = false;
        LinkedHashMap<Integer, Collection> map;

        hasFileExisted ();

        map = (LinkedHashMap<Integer, Collection>) fetchMapData ();
        
        // delete selected collection
        if ( !VerifyVariable.isEmptyOrDefault(data) ) {
            map.remove (id);
            hasRemoved = true;
        }

        if (hasRemoved ) {
            commitMapData (map, MESSAGE_DELETE_COLLECTION);
        }
        
        return hasRemoved;
    }  
}
