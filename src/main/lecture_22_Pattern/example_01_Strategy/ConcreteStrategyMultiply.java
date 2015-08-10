package example_01_Strategy;

/**
 * Created by aalex on 8/10/15.
 */
public class ConcreteStrategyMultiply implements Strategy {
    @Override
    public int execute(int a, int b) {
        System.out.println("ConcreteStrategyMultiply -> execute ");
        return a*b;
    }
}
