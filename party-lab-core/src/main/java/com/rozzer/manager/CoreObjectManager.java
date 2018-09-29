package com.rozzer.manager;

import com.rozzer.common.Saved;
import org.springframework.beans.factory.annotation.Autowired;

public class CoreObjectManager {

    private static CoreObjectManager instance = new CoreObjectManager();

    public static CoreObjectManager getInstance() {
        return instance;
    }

    private ManagerFactory managerFactory;

    @Autowired
    public static void setManagerFactory(ManagerFactory factory) {
        instance.managerFactory = factory;
    }

    public static ManagerFactory getManagerFactory() {
        return instance.managerFactory;
    }

    private CoreObjectManager() {
    }

    public void setManagerFactory(ManagerFactory factory) {
        this.managerFactory = factory;
    }

    public ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    public <T extends Saved> Manager<T>  getManager(Class<T> clazz){
        return managerFactory.getManager(clazz);
    }
}
