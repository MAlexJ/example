package lecture_01_stream;


import java.util.HashMap;
import java.util.Map;

/**
 * Map - ������, ������� ������ ���� ����-�������� � �� ����� ��������� ������������� ������.
 * ��� ���������� �������� �� ������������� ����� ���������� ������ ������ �������� �� ����� ������ �������.
 * ��� ������������� ��������� ������:
 */
public class TestMap_01 {

    public static void main(String[] args) {
        Map<String, String> mapStr = new HashMap<>();
        mapStr.put("1", "asd");
        mapStr.put("1", "ewq");

        //����� Map �� �����  System.out.println()
        System.out.println(mapStr);
    }

}
