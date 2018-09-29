package com.rozzer.controller.common;

import com.rozzer.common.AbstractSaved;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;

public class ControllerHelper {

    public static  <T extends AbstractSaved> Manager<T> manager(Class<T> clazz){
        return CoreObjectManager.getInstance().getManager(clazz);
    }
}
