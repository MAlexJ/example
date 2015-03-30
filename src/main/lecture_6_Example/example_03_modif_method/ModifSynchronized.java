package example_03_modif_method;
public class ModifSynchronized {

    public static void main(String[] args) {
        ModifSynchronized modifSynchronize = new ModifSynchronized();
        modifSynchronize.f();
        System.out.println("Hello");
    }
    synchronized void f(){
        System.out.println();
    }

}
