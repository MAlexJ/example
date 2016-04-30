
public class InterfaceDefaultMethod {
    public static void main(String[] args) {
        Cc c = new Cc();
        c.default_method(6);   //TOdO 1. print: 12, 2. print: 7
    }
}

class Cc implements Bb{
//    @Override                             //TODO 1
//    public void default_method(int i) {
//        System.out.println("override: "+i*2);
//    }
}

interface Bb {
    default void default_method(int i){
        System.out.println(++i);            //TODO 2
    }
}