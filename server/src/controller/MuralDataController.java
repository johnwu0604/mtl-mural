package controller;

import jdk.nashorn.internal.parser.JSONParser;
import model.MuralData;
import sun.jvm.hotspot.debugger.Page;
import sun.net.www.http.HttpClient;
import sun.net.www.protocol.http.HttpURLConnection;
import model.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import com.google.gson.Gson;
import org.json.*;

/**
 * Created by JohnWu on 2017-01-28.
 */
public class MuralDataController {


    public MuralDataController() {

    }

    public List<Mural> getMuralData() {

        List<Mural> listOfMurals = new ArrayList<Mural>();

        try {
            Gson gson = new Gson();

            String str = readUrl("http://donnees.ville.montreal.qc.ca/dataset/53d2e586-6e7f-4eae-89a1-2cfa7fc29fa0/resource/d325352b-1c06-4c3a-bf5e-1e4c98e0636b/download/murales.json");
            JSONObject obj = new JSONObject(str);
            JSONArray res = obj.getJSONArray("features");


            for(int i = 0; i < res.length(); i++){
                // Mural Object
                Mural mural = new Mural();
                Geometry geometry = new Geometry();
                Properties properties = new Properties();

                JSONObject jsonMuralObject = res.getJSONObject(i);
                JSONObject jsonGeometry = jsonMuralObject.getJSONObject("geometry");
                JSONArray jsonCoordinates = jsonGeometry.getJSONArray("coordinates");
                JSONObject jsonProperties = jsonMuralObject.getJSONObject("properties");

                geometry.setCoordinates(new double[]{jsonCoordinates.getDouble(1), jsonCoordinates.getDouble(0)});

                properties.setId(jsonProperties.getInt("id"));
                properties.setFile(jsonProperties.getString("fichier"));
                properties.setArtist(jsonProperties.getString("artiste"));
                properties.setOrganisation(jsonProperties.getString("organisation"));
                properties.setArtist(jsonProperties.getString("artiste"));
                properties.setAddress(jsonProperties.getString("adresse"));
                properties.setYear(jsonProperties.getInt("annee"));
                properties.setLatitude(jsonProperties.getDouble("latitude"));
                properties.setLongitude(jsonProperties.getDouble("longitude"));
                properties.setImage(jsonProperties.getString("image"));
                properties.setProgram(jsonProperties.getString("programme_entente"));

                mural.setGeometry(geometry);
                mural.setProperties(properties);


                listOfMurals.add(mural);
            }


        }catch(Exception e){}

        return listOfMurals;
    }


    private String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }

    }

}
