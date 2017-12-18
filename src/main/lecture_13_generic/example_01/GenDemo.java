package example_01;

public class GenDemo
{
    public static void main(String[] args)
    {
        Gen<Integer> iOb = new Gen<>(192);
        System.out.println("Gen<Integer> iOb: " + iOb.getObj());
        iOb.isShowType();

        Gen<String> sOb = new Gen<>("This is string.");
        System.out.println("Gen<String> sOb: " + sOb);
        sOb.isShowType();

    }
}
