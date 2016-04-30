
public class ExtendsCassTheInterface {
    public static void main(String[] args) {
        D d = new C() {
            @Override
            void method_2() {
            }

            @Override
            public void method() {
            }
        };
    }
}

abstract class C implements D {
    abstract void method_2();
}

interface D {
    void method();
}
