package com.malex.lecture_25_Java_8.example_01_default_and_static_method_interface;

import java.util.function.Supplier;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

/**
 * Main class
 */
@Log4j
public class DefaultInterfaceTest {

    @Test
    public void test() {
        // #1
        log.debug("Invoke the default method inside interface: " + new IDefaultInterface() {
        }.notRequired("Current"));

        // #1.1
        log.debug("Invoke the default method: " + new DefaultImpl().notRequired("Class"));

        // #2
        IDefaultInterface iFactory = DefaultFactory.create(DefaultImpl::new);
        log.debug(iFactory.notRequired("Factory"));

        // #3
        iFactory = DefaultFactory.create(OverrideDefaultImpl::new);
        log.debug(iFactory.notRequired("Override"));
    }
}

/**
 * Example of using the default method
 */
interface IDefaultInterface {

    /**
     * This is the default method
     *
     * @return some string
     */
    default String notRequired(String str) {
        return String.format("Default implementation `%s`", str);
    }
}

/**
 * Factory
 */
interface DefaultFactory {
    static IDefaultInterface create(Supplier<IDefaultInterface> supplier) {
        return supplier.get();
    }
}

/**
 * Implementation of interface
 */
class DefaultImpl implements IDefaultInterface {
}

/**
 * Override Implementation of interface
 */
class OverrideDefaultImpl implements IDefaultInterface {
    @Override
    public String notRequired(String str) {
        return String.format("New implementation `%s`", str);
    }
}