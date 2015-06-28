package lecture_02_semantics.example_00;


public class TestEx {

    public static void main(String[] args) {


    }

    public static void f() throws Exception {

        try {
            g();
        } catch (Exception e) {
            // логирование - файл / ->инет бд
            System.out.println("Error");
            // mrthod alert 0 / -1
            // close();
            //log
            throw  e;

        }

    }

    //Driver ||  DB
    public static void g() throws Exception {

        throw new Exception();
    }

}
