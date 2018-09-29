package com.rozzer.controller.common;

import com.rozzer.manager.CoreObjectManager;
import com.rozzer.manager.Manager;
import com.rozzer.model.Book;

public class ControllerHelper {

    public static  <T extends Book> Manager<T> manager(Class<T> clazz){
        return CoreObjectManager.getInstance().getManager(clazz);
    }
}
