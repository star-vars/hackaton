package com.rozzer.controller;

import com.google.common.base.Strings;
import com.rozzer.controller.oauth.AccessTokenService;
import com.rozzer.controller.oauth.InvalidOAuthStateException;
import com.rozzer.controller.oauth.SessionDataImpl;
import com.rozzer.manager.PLUserManager;
import com.rozzer.model.PLUser;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import static com.rozzer.controller.common.ControllerHelper.manager;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController {

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    private SessionDataImpl sessionData;

    @RequestMapping(value = "authorized")
    public void authorized(@RequestParam("code") final String code,
                             @RequestParam("state") final long state,
                             final HttpSession session, HttpServletResponse response) throws Exception {
        if (sessionData.getUser() == null) {
            long sessionState = (long) session.getAttribute("state");
            if (state != sessionState) {
                throw new InvalidOAuthStateException(state, sessionState);
            }
            sessionData.setGhClient(new GitHubClient().setOAuth2Token(accessTokenService.getAccessToken(code)));
            UserService service = new UserService(sessionData.getGhClient());
            User ghUser = service.getUser();
            String login = ghUser.getLogin();
            String email = ghUser.getEmail();
            if (Strings.isNullOrEmpty(email)) {
                List<String> emails = service.getEmails();
                if (emails != null && emails.size() > 0) {
                    email = emails.get(0);
                }
            }
            String finalEmail = email;
            String name = ghUser.getName();
            String avatarUrl = ghUser.getAvatarUrl();
            PLUser plUser = manager(PLUser.class, PLUserManager.class).getByLogin(login).orElseGet(() -> {
                PLUser user = manager(PLUser.class).create();
                user.setName(name);
                user.setLogin(login);
                user.setMail(finalEmail);
                user.setAvatarUrl(avatarUrl);
                manager(PLUser.class).save(user);
                return user;
            });
            sessionData.setUser(plUser);
        }
        response.sendRedirect("/");
    }

}
