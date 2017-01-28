package model;

import java.util.Arrays;

/**
 * Created by JohnWu on 2017-01-28.
 */
public class Geometry {

    private double[] coordinates;

    public Geometry() {

    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String toString(){
        return Arrays.toString(this.coordinates);
    }
}
