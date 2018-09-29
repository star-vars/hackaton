package com.rozzer.model;

import com.rozzer.common.AbstractSaved;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "comments")
public class Comment extends AbstractSaved {

    @ManyToOne
    private PLUser user;
    private String text;
    private Date dateTime;

    public Comment() {
    }

    public Comment(String name) {
        super(name);
    }

    @Override
    public void save() {

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
}
