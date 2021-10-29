package Map;

public class Map {
    private String mapName;
    private String mapLocation;
    private int number;
    
    public Map(String mapName, String mapLocation, int number) {
        this.mapName = mapName;
        this.mapLocation = mapLocation;
        this.number = number;
    }
    
    public String getName() {
        return this.mapName;
    }
    
    public String getMapLocation() {
        return this.mapLocation;
    }
    
    public int getNumber() {
        return this.number;
    }
}
