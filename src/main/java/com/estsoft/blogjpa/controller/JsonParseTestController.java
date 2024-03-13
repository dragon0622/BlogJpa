package com.estsoft.blogjpa.controller;

import com.estsoft.blogjpa.external.ExternalApiParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonParseTestController {
    private final ExternalApiParser externalApiParser;

    public JsonParseTestController(ExternalApiParser externalApiParser) {
        this.externalApiParser = externalApiParser;
    }

    @GetMapping("/api/test")
    public String test(){
        externalApiParser.parseAndSave();
        return "";
    }
}
