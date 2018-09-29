package com.rozzer.controller;

import com.rozzer.controller.oauth.AccessTokenService;
import com.rozzer.controller.oauth.InvalidOAuthStateException;
import com.rozzer.controller.oauth.SessionData;
import com.rozzer.manager.PLUserManager;
import com.rozzer.model.PLUser;
import org.eclipse.egit.github.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import java.util.Optional;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    private SessionData sessionData;

    @RequestMapping(value = "authorized")
    public String authorized(@RequestParam("code") final String code,
                             @RequestParam("state") final long state,
                             final HttpSession session) throws Exception {
        if (sessionData.getUser() == null) {
            long sessionState = (long) session.getAttribute("state");
            if (state != sessionState) {
                throw new InvalidOAuthStateException(state, sessionState);
            }
            sessionData.setAccessToken(accessTokenService.getAccessToken(code));
            UserService service = new UserService();
            service.getClient().setOAuth2Token(sessionData.getAccessToken());
            org.eclipse.egit.github.core.User ghUser = service.getUser();
            String login = ghUser.getLogin();
            String email = ghUser.getEmail();
            PLUser plUser = manager(PLUser.class, PLUserManager.class).getByNameAndEmail(login, email).orElseGet(() -> {
                PLUser user = manager(PLUser.class).create();
                user.setName(login);
                user.setMail(email);
                manager(PLUser.class).save(user);
                return user;
            });
            sessionData.setUser(plUser);
            return "Logged in to gh, login " + login + " email " + email;
        } else {
            return "No login data";
        }
    }

}
