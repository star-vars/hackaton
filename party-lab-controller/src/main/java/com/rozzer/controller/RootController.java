package com.rozzer.controller;

import com.rozzer.controller.oauth.SessionDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Random;

@Controller
public class RootController {

    private static final Random RANDOM = new SecureRandom();
    private final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://github.com/login/oauth/authorize");
    @Autowired
    private SessionDataImpl sessionData;

    @Autowired
    public RootController(@Value("${api.client_id}") String clientId,
                          @Value("${api.scope}") String scope,
                          @Value("${api.redirect_uri}") String redirectUri) {
        builder.queryParam("client_id", clientId);
        builder.queryParam("scope", scope);
        builder.queryParam("redirect_uri", redirectUri);
    }

    @RequestMapping("/")
    public String viewOrLogin(final HttpSession httpSession, final Model model) {

        final long state = RANDOM.nextLong();

        sessionData.setState(state);

        httpSession.setAttribute("state", state);
        builder.replaceQueryParam("state", state);
        model.addAttribute("authorizeURL", builder.toUriString());

        if (sessionData.getUser() == null) {
            return "login";
        } else {
            return "index";
        }
    }

}
