package example_01_Strategy;

public class ConcreteStrategySubtract implements Strategy{
    @Override
    public int execute(int a, int b) {
        System.out.println("ConcreteStrategySubtract -> execute ");
        return a-b;
    }
}
