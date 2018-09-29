package com.rozzer.gh.ext;

import org.eclipse.egit.github.core.CommitUser;

public class NewCommit {

    private String message;
    private String content;
    private String branch;
    private String sha;
    private CommitUser committer;
    private CommitUser author;

    public String getMessage() {
        return message;
    }

    public NewCommit setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NewCommit setContent(String content) {
        this.content = content;
        return this;
    }

    public String getBranch() {
        return branch;
    }

    public NewCommit setBranch(String branch) {
        this.branch = branch;
        return this;
    }

    public CommitUser getCommitter() {
        return committer;
    }

    public NewCommit setCommitter(CommitUser committer) {
        this.committer = committer;
        return this;
    }

    public CommitUser getAuthor() {
        return author;
    }

    public NewCommit setAuthor(CommitUser author) {
        this.author = author;
        return this;
    }

    public String getSha() {
        return sha;
    }

    public NewCommit setSha(String sha) {
        this.sha = sha;
        return this;
    }
}
