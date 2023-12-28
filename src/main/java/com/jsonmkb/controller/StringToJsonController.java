package com.jsonmkb.controller;

import com.jsonmkb.sevice.StringToJsonService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StringToJsonController {

    private final StringToJsonService service;

    @Autowired
    public StringToJsonController(StringToJsonService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public void startServer () {
        System.out.println("=====================IN ============================");
    }


    @GetMapping("/scraping/json")
    @ResponseBody
    public JSONObject stringToJson(String fileName, int type) throws Exception{
        return service.stringToJson(fileName, type);
    }
}
