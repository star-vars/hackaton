package com.rozzer.common;

public interface Saved extends Identity, Named {

    /**
     * Save current object
     */
    void save();
}
