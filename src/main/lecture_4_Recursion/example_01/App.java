package example_01;

public class App {
    public static void main(String[] args) {
        System.out.println("10 - �������� ����� odd: " + isOdd(1));
        System.out.println("10 - ������ ����� even:   " + isEven(1));
    }

    // �������� �� ��������
    public static boolean isEven(int k) {
        if (k == 0) {
            return true; // 0 - ������ �����
        } else {
            return isOdd(k - 1);
        }
    }

    // �������� �� ����������
    public static boolean isOdd(int k) {
        if (k == 0) {
            return false; // 0 - �� �������� �����
        } else {
            return isEven(k - 1);
        }
    }
}

