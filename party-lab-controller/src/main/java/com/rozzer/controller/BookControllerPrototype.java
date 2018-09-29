package com.rozzer.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Deprecated
@RestController
public class BookControllerPrototype {

    @RequestMapping(value = "/lab", method = RequestMethod.GET)
    public String validate(){
        return "lab successful";
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/rozzer/lab/lab", method = RequestMethod.POST, produces = "application/json")
    public String index2(@RequestBody String id){
        return id;
    }
}
