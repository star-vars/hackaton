package com.rozzer.controller.oauth;

import com.rozzer.model.PLUser;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionData {

    private PLUser user;
    private GitHubClient ghClient;

    public PLUser getUser() {
        return user;
    }

    public void setUser(PLUser user) {
        this.user = user;
    }

    public GitHubClient getGhClient() {
        return ghClient;
    }

    public void setGhClient(GitHubClient ghClient) {
        this.ghClient = ghClient;
    }
}
