package utils;


import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;

public class Dataprovider {

    JSONParser jsonParser = new JSONParser();
    FileReader reader = new FileReader("src/test/resources/conf/parallel.conf.json");

    public Dataprovider() throws IOException, ParseException {


        Object obj = jsonParser.parse(reader);
        JSONObject data = (JSONObject) obj;
        JSONArray dataArray = (JSONArray) data.get("environments");
        String arr[] = new String[dataArray.size()];

        for (int i = 0; i < dataArray.size(); i++) {

            JSONObject devices = (JSONObject) dataArray.get(i);
            String device = (String) devices.get("os_version");
            System.out.println("Datos json");
            System.out.println("Version" + device);
        }


    }


}




