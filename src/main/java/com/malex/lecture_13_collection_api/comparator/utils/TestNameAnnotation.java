package com.malex.lecture_13_collection_api.comparator.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestNameAnnotation {
    String name();
}