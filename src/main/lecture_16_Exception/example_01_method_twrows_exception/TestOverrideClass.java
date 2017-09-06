package example_01_method_twrows_exception;


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


		EvilThrower.throwAnyway(new MyException("Incoming the parameter is null!"));


	}


	static class EvilThrower {

		private static <T extends Exception> void doWork(Exception ex) throws T {
			throw (T) ex;
		}

		public static void throwAnyway(Exception e) {
			EvilThrower.<RuntimeException>doWork(e);
		}
	}


}