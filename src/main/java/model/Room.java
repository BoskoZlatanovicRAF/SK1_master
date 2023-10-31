package model;

import java.util.HashMap;

public class Room {

    String name;
    HashMap<String, String> features;
    public Room(String name) {
        this.name = name;
        this.features = new HashMap<>();
    }

    public boolean addFeature(String key, String value){

        if (!features.keySet().contains(key)) {

            features.put(key, value);
            return true;
        }
        return false;
    }
}
