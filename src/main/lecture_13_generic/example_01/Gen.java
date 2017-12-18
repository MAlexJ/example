package example_01;

class Gen<T>
{
    private T obj;

    Gen(T obj)
    {
        this.obj = obj;
    }

    T getObj()
    {
        return this.obj;
    }

    void isShowType()
    {
        System.out.println("Type: " + obj.getClass().getName() + "\n");
    }
}
