package com.rozzer.model;

import com.google.common.collect.Sets;
import com.rozzer.common.AbstractSaved;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity(name = "comments")
public class Comment extends AbstractSaved {

    @ManyToOne
    private PLUser user;
    private String text;
    private Date dateTime;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<PLUser> likers = Sets.newHashSet();

    public Comment() {
    }

    public Comment(String name) {
        super(name);
    }

    public PLUser getUser() {
        return user;
    }

    public void setUser(PLUser user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Set<PLUser> getLikers() {
        return likers;
    }
}
