package com.rozzer.common;

import javax.annotation.Nonnull;

public interface Named {

    /**
     * @return name for object
     */
    @Nonnull
    String getName();

    /**
     * @param name for set in object
     */
    void setName(@Nonnull String name);
}
