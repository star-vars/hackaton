package com.rozzer.manager;

import com.rozzer.common.Saved;

public interface ManagerFactory {
    <U extends Saved> Manager getManager(Class<U> clazz);
    void register(Class<? extends Saved> clazz, Manager manager);
}
