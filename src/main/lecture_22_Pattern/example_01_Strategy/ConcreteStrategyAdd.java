package example_01_Strategy;

public class ConcreteStrategyAdd implements Strategy{
    @Override
    public int execute(int a, int b) {
        System.out.println("ConcreteStrategyAdd -> execute ");
        return a+b;
    }
}
