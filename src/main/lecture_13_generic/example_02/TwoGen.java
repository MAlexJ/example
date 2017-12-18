package example_02;

public class TwoGen<T, V>
{
    private T obj_1;
    private V obj_2;

    TwoGen(T obj_1, V obj_2)
    {
        this.obj_1 = obj_1;
        this.obj_2 = obj_2;
    }

    void isShowType()
    {
        System.out.println("First type T: " + obj_1);
        System.out.println("First type V: " + obj_2 + "\n");
    }

    public T getObj_1()
    {
        return obj_1;
    }

    public V getObj_2()
    {
        return obj_2;
    }
}
