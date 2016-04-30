public class ExtendsInterface {
    public static void main(String[] args) {
        new B() {
            @Override
            public void method_3() {
            }

            @Override
            public void method_1() {
            }

            @Override
            public void method_2() {
            }
        };
    }
}

interface A {
    void method_1();

    void method_2();
}

interface B extends A {
    void method_3();
}
