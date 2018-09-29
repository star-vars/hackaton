package com.rozzer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Random;

@Deprecated
@RestController
public class ControllerPrototype {

    private static final Random RANDOM = new SecureRandom();

    @Value("${api.client_id}")
    private String clientId;

    @Value("${api.client_secret}")
    private String clientSecret;

    @RequestMapping(value = "/lab", method = RequestMethod.GET)
    public String validate(){
        return "lab successful";
    }

    @RequestMapping("/")
    public String index(final HttpSession httpSession) {
        final long state = RANDOM.nextLong();
        httpSession.setAttribute("state", state);

        return "<a href=\"https://github.com/login/oauth/authorize?client_id=" + clientId + "&scope=user,repo&redirect_uri=http://localhost:8080/logged/authorized&state=" + state + "\">Click</a>";
    }

    @RequestMapping(value = "/rozzer/lab/lab", method = RequestMethod.POST, produces = "application/json")
    public String index2(@RequestBody String id){
        return id;
    }
}
