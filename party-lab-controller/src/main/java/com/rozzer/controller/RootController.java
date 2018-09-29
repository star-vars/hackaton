package com.rozzer.controller;

import com.rozzer.session.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RootController {

    @Autowired
    private SessionData sessionData;

    @RequestMapping("/")
    public String viewOrLogin(final HttpSession httpSession, final Model model) {
        if (sessionData.getUser() == null) {
            return "login";
        } else {
            return "index";
        }
    }

}
