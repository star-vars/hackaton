package com.rozzer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class AppController {

    @Value("${api.client_id}")
    private String clientId;

    @RequestMapping("ghClientId")
    public String ghClientId() {
        return clientId;
    }

}
