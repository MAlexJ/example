package lecure_01_exeption_syntax.example_01;


public class WashingMachine {
    Engine engine = new Engine();

    public void wash(int voltage) {
        // ��� ����, �������
        engine.run(voltage);
    }
}
