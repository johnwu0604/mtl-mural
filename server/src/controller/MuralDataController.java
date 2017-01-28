package controller;

import model.MuralData;
import sun.net.www.http.HttpClient;

/**
 * Created by JohnWu on 2017-01-28.
 */
public class MuralDataController {

    HttpClient client;
    String url;

    public MuralDataController() {
        url = "http://donnees.ville.montreal.qc.ca/dataset/53d2e586-6e7f-4eae-89a1-2cfa7fc29fa0/resource/d325352b-1c06-4c3a-bf5e-1e4c98e0636b/download/murales.json";
        client = new HttpClient(new URL(url));
        System.out.println(client);
    }

    public static MuralData getMuralData() {

        MuralData muralData = new MuralData();

        return muralData;

    }

    public static void main(String[] args){
        Mu
    }

}
