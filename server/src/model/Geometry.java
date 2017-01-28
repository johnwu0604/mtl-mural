package model;

/**
 * Created by JohnWu on 2017-01-28.
 */
public class Geometry {

    private String type;
    private int[] coordinates;

    public Geometry() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }
}
