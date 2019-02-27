package com.allianz.pa.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME) 
@Target({FIELD, METHOD})
public @interface JsonConfig {
    Class type() default String.class;
    boolean require() default false;
    int length() default Integer.MAX_VALUE;
    String datePattern() default "yyyyMMddHHmmss";
    String[] enumValue() default {};
}
