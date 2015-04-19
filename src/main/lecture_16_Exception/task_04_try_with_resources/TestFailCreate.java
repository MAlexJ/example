package task_04_try_with_resources;


public class TestFailCreate {

    public static void main(String[] args) {
        try (FailCreate x = new FailCreate("test")) {
            System.err.println("body");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
