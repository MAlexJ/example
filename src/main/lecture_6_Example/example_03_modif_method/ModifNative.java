package example_03_modif_method;

public class ModifNative {
    public static void main(String[] args) {
        ModifNative modifNative = new ModifNative();
        //modifNative.f();
        System.out.println("Hello");


    }

    //windows -> file.dll (C:\Windows\System32) dynamic link libraries -> .dll
    native void f();

}
