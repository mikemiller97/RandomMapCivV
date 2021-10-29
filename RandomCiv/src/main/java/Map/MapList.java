package Map;

import java.util.ArrayList;
import java.util.Random;

public class MapList {
    private ArrayList<Map> mapList;
    
    public MapList() {
        this.mapList = new ArrayList<>();
    }
    
    public void add(Map map) {
        this.mapList.add(map);
    }
    
    //Selects a random map
    public String pick() {
        Random random = new Random();
        int randomNumber = random.nextInt(64) + 1;
        for (Map map : this.mapList) {
            if (randomNumber == map.getNumber()) {
                return map.getName() + " (" + map.getMapLocation() + ")";
            }
        }
        return "Error, no map chosen.";
    }
    
}
