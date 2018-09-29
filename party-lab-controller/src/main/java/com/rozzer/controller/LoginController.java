package com.rozzer.controller;

import com.rozzer.controller.oauth.InvalidOAuthStateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "authorized")
    public String authorized(@RequestParam("code") final String code,
                             @RequestParam("state") final long state,
                             final HttpSession session) {
        long sessionState = (long) session.getAttribute("state");
        if (state != sessionState) {
            throw new InvalidOAuthStateException(state, sessionState);
        }
        return "Ok";
    }

}
