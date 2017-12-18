package example_02;

public class SimpGen
{
    public static void main(String[] args)
    {
        TwoGen<Integer, String> twoGen = new TwoGen<>(12, "Text bla bla bla");
        System.out.println("T: " + twoGen.getObj_1() + " V: " + twoGen.getObj_2());
        twoGen.isShowType();
    }
}
