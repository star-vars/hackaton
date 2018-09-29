package com.rozzer.session;

import com.rozzer.model.PLUser;
import org.eclipse.egit.github.core.client.GitHubClient;

public interface SessionData {
    PLUser getUser();
    GitHubClient getGhClient();
}
