package com.rozzer.common;

import javax.annotation.Nonnull;

/**
 * The interface do to identify the uniqueness of the object
 */
public interface Identity {

    /**
     * @return uniqueness id
     */
    @Nonnull
    Long getId();

    /**
     *
     * @param id is uniqueness in DB
     */
    void setId(@Nonnull Long id);
}
