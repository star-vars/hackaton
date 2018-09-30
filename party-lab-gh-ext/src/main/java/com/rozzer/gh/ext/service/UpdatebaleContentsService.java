package com.rozzer.gh.ext.service;

import com.google.gson.reflect.TypeToken;
import com.rozzer.gh.ext.CommitResponse;
import com.rozzer.gh.ext.NewCommit;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.GitHubRequest;
import org.eclipse.egit.github.core.service.GitHubService;

import java.io.IOException;
import java.util.List;

import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_CONTENTS;
import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_REPOS;

public class UpdatebaleContentsService extends GitHubService {

    /**
     * Create contents service
     */
    public UpdatebaleContentsService() {
        super();
    }

    /**
     * Create contents service
     *
     * @param client
     */
    public UpdatebaleContentsService(final GitHubClient client) {
        super(client);
    }

    public CommitResponse createFile(IRepositoryIdProvider repository, String path, NewCommit commit)
            throws IOException {
        String id = getId(repository);

        StringBuilder uri = new StringBuilder(SEGMENT_REPOS);
        uri.append('/').append(id);
        uri.append(SEGMENT_CONTENTS);
        if (path != null && path.length() > 0) {
            if (path.charAt(0) != '/')
                uri.append('/');
            uri.append(path);
        }
        if (commit.getAuthor().getEmail() == null) {
            commit.getAuthor().setEmail("");
        }
        if (commit.getAuthor().getName() == null) {
            commit.getAuthor().setName("");
        }
        if (commit.getCommitter().getEmail() == null) {
            commit.getCommitter().setEmail("");
        }
        if (commit.getCommitter().getName() == null) {
            commit.getCommitter().setName("");
        }
        return client.put(uri.toString(), commit, CommitResponse.class);
    }

    public CommitResponse updateFile(IRepositoryIdProvider repository, String path, NewCommit commit)
            throws IOException {
        String id = getId(repository);

        StringBuilder uri = new StringBuilder(SEGMENT_REPOS);
        uri.append('/').append(id);
        uri.append(SEGMENT_CONTENTS);
        if (path != null && path.length() > 0) {
            if (path.charAt(0) != '/')
                uri.append('/');
            uri.append(path);
        }
        return client.put(uri.toString(), commit, CommitResponse.class);
    }

    public void deleteFile(IRepositoryIdProvider repository, String path, NewCommit commit)
            throws IOException {
        String id = getId(repository);

        StringBuilder uri = new StringBuilder(SEGMENT_REPOS);
        uri.append('/').append(id);
        uri.append(SEGMENT_CONTENTS);
        if (path != null && path.length() > 0) {
            if (path.charAt(0) != '/')
                uri.append('/');
            uri.append(path);
        }
        client.delete(uri.toString(), commit);
    }

}
