package com.rozzer.controller.oauth;

import com.rozzer.model.PLUser;
import com.rozzer.session.SessionData;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionDataImpl implements SessionData {

    private PLUser user;
    private GitHubClient ghClient;

    @Override
    public PLUser getUser() {
        return user;
    }

    public void setUser(PLUser user) {
        this.user = user;
    }

    @Override
    public GitHubClient getGhClient() {
        return ghClient;
    }

    public void setGhClient(GitHubClient ghClient) {
        this.ghClient = ghClient;
    }
}
