package com.rozzer.controller;

import com.google.common.base.Strings;
import com.rozzer.controller.oauth.AccessTokenService;
import com.rozzer.controller.oauth.InvalidOAuthStateException;
import com.rozzer.controller.oauth.SessionData;
import com.rozzer.manager.PLUserManager;
import com.rozzer.model.PLUser;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/logged")
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
            sessionData.setGhClient(new GitHubClient(accessTokenService.getAccessToken(code)));
            UserService service = new UserService(sessionData.getGhClient());
            org.eclipse.egit.github.core.User ghUser = service.getUser();
            String login = ghUser.getLogin();
            String name = ghUser.getName();
            String email = ghUser.getEmail();
            if (Strings.isNullOrEmpty(email)) {
                List<String> emails = service.getEmails();
                if (emails != null && emails.size() > 0) {
                    email = emails.get(0);
                }
            }
            String finalEmail = email;
            PLUser plUser = manager(PLUser.class, PLUserManager.class).getByLogin(login).orElseGet(() -> {
                PLUser user = manager(PLUser.class).create();
                user.setName(name);
                user.setLogin(login);
                user.setMail(finalEmail);
                manager(PLUser.class).save(user);
                return user;
            });
            sessionData.setUser(plUser);
            return "Logged in to gh, login " + login + " email " + finalEmail;
        } else {
            return "Already logged in, login " + sessionData.getUser().getLogin() + " email " + sessionData.getUser().getMail() ;
        }
    }

}
