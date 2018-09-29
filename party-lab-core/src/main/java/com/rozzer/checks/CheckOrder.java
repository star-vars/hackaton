package com.rozzer.checks;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface CheckOrder {

    int value() default 0;

}
