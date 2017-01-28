package model;

/**
 * Created by JohnWu on 2017-01-28.
 */
public class Mural {

    private Properties properties;
    private Geometry geometry;

    public Mural() {

    }


    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String toString(){
        return "Coordinates: " + this.geometry + ", Properties: " + this.properties;
    }
}
