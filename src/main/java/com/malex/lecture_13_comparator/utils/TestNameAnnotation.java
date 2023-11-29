package com.malex.lecture_13_comparator.utils;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestNameAnnotation {
    String name();
}