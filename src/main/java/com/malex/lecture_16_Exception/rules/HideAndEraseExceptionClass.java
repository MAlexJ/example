package com.malex.lecture_16_Exception.rules;

import org.junit.Test;

/** Hide and erase the checked exception to using generic erase typing */
public class HideAndEraseExceptionClass {

  @Test(expected = Exception.class)
  public void testStaticMethod() {
    HideAndEraseExceptionClass.doSomething();
  }

  @Test(expected = Exception.class)
  public void testNoStaticMethod() {
    var hideAndEraseException = new HideAndEraseExceptionClass();
    hideAndEraseException.doSomethingNoStatic();
  }

  protected static void doSomething() {
    EvilThrower.throwAnyway(new Exception("Incoming the parameter is wrong!"));
  }

  protected void doSomethingNoStatic() {
    new EvilThrower().throwAnywayNoStatic(new Exception("Incoming the parameter is wrong!"));
  }

  private static class EvilThrower {

    private EvilThrower() {
      // non use
    }

    public static void throwAnyway(Exception e) {
      EvilThrower.doWork(e);
    }

    public void throwAnywayNoStatic(Exception e) {
      doWorkNoStatic(e);
    }

    /** WTF: Erase checked exception */
    private static <T extends Exception> void doWork(Exception ex) throws T {
      throw (T) ex;
    }

    /** WTF: Erase checked exception */
    private <T extends Exception> void doWorkNoStatic(Exception ex) throws T {
      throw (T) ex;
    }
  }
}
