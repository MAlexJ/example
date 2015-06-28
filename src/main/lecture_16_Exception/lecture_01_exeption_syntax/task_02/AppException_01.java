package lecture_01_exeption_syntax.task_02;


public class AppException_01 {

    public static void main(String[] args) {
        System.err.println(">1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(">1.out"); // вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void f() {
        System.err.println(".   >2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   >2.out");  //вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void g() {
        System.err.println(".   .   >3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   >3.out"); // вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void h() {
        System.err.println(".   .   .   >4.in");
        if (true) {
            System.err.println(".   .   .   >4.RETURN");
            return; // выходим из текущего фрейма по 'return'
        }
        System.err.println(".   .   .   >4.out"); // ПРОПУСКАЕМ
    }

}
