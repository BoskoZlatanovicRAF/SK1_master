package model;

import lombok.Getter;

import java.util.HashMap;
@Getter
public class Room {


    //WHAT ABOUT RoomManagerInterface or abstract class keeps track of the rooms adding features to the rooms and would be useful as having header when serialising or deserializing ?
    HashMap<String, Object> features;
    String name;


    public boolean addFeature(String key, Object val){

        if (!features.keySet().contains(key)) {

            features.put(key, val);
            return true;
        }
        return false;
    }

}
