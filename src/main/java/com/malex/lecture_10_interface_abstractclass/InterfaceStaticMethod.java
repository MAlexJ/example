/**
 * Created by malex on 29.04.2016.
 */
public class InterfaceStaticMethod {
    public static void main(String[] args) {
        System.out.println(Aa.static_method(5));
    }
}

interface Aa {
    static int static_method(int i){
        return i*2;
    }
}