package com.malex.lecture_16_Exception.example_01_method_twrows_exception;


/**
 * How to make a method that throws an exception
 *
 * @author malex
 */
public class TestOverrideClass extends EvilClass {

    public static void main(String[] args) {
        new TestOverrideClass().doSomething("dsg");
    }

    @Override
    protected void doSomething(String str) {
        EvilThrower.throwAnyway(new Exception("Incoming the parameter is null!"));
    }


    private static class EvilThrower {

        private EvilThrower() {
            // non use
        }

        private static <T extends Exception> void doWork(Exception ex) throws T {
            throw (T) ex;
        }

        static void throwAnyway(Exception e) {
            EvilThrower.doWork(e);
        }
    }

}

abstract class EvilClass {

    abstract void doSomething(String str);
}
