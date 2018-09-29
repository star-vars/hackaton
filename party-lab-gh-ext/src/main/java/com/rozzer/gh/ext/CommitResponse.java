package com.rozzer.gh.ext;

import org.eclipse.egit.github.core.Commit;
import org.eclipse.egit.github.core.RepositoryContents;

public class CommitResponse {

    private RepositoryContents content;
    private Commit commit;

    public RepositoryContents getContent() {
        return content;
    }

    public CommitResponse setContent(RepositoryContents content) {
        this.content = content;
        return this;
    }

    public Commit getCommit() {
        return commit;
    }

    public CommitResponse setCommit(Commit commit) {
        this.commit = commit;
        return this;
    }
}
