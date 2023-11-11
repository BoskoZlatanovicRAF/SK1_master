package model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class Room {

    String name;
    HashMap<String, String> features = new HashMap<>();
    public Room(){
        features = new HashMap<>();
    }

    public Room(String name) {
        this.name = name;
        this.features = new HashMap<>();
    }

    public Room(String name, HashMap<String, String> features) {
        this.name = name;
        this.features = features;
    }

    public boolean addFeature(String key, String value){

        if (!features.keySet().contains(key)) {

            features.put(key, value);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String featuresStr = features.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", "));
        return "Room[name=" + name + ", features={" + featuresStr + "}]";
    }
}
