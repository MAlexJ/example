package task_04_try_with_resources;


public class FailCreate implements  AutoCloseable {
    private String msg;
    public FailCreate(String msg) {
        this.msg = msg;
        System.err.println("new:" + msg);
       // throw new Error(msg);
    }
    @Override
    public void close() throws Exception {
        System.err.println("close:" + msg);
    }
}
