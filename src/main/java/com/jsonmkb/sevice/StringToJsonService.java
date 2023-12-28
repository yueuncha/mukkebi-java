package com.jsonmkb.sevice;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Service
public class StringToJsonService {

    public JSONObject stringToJson(String fileName, int type) throws IOException, ParseException {
        String jsonStr;

        String testBaseUrl = "http://52.78.144.77/data/excel/";
        String serverBaseUrl = " https://boss.mukkebi.com/data/excel/";
        String fileNameStr = "shopdata_"+fileName+".json";
        String urlStr = "";

        if(type == 1){
            urlStr = testBaseUrl + fileNameStr;
        }else{
            urlStr = serverBaseUrl + fileNameStr;
        }

        URL url = new URL(urlStr);
        JSONParser parser = new JSONParser();
        URLConnection in = null;
        in = url.openConnection();
        BufferedReader buffer = new BufferedReader(
                new InputStreamReader(in.getInputStream())
        );

        jsonStr = buffer.readLine();
        jsonStr = (String) parser.parse(jsonStr);
        JSONObject json = (JSONObject) parser.parse(jsonStr);

        return json;
    }

}
