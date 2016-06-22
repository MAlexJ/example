package lecure_01_exeption_syntax.task_01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 20.05.2015.
 */
public class TestMap_02 {

    public static void main(String[] args) {
        Map<Integer, String> mapStr = new HashMap<>();
        mapStr.put(1, "asd");
        mapStr.put(2, "ewq");
        mapStr.put(5, "ewq");
        mapStr.put(3, "ewq");
        mapStr.put(4, "ewq");

        //����� Map �� �����  System.out.println()
        System.out.println(mapStr);


        //��������� Map ������������� ��� ������� ��� ������� � ������:

        //Set �� ������ (����� keySet)
        Set<Integer> integerSet = mapStr.keySet();
        System.out.println(" Set<Integer> integerSet = mapStr.keySet(); -> " + integerSet);
        System.out.println();

        //��������� �� �������� (����� values);
        Collection<String> stringCollection = mapStr.values();
        System.out.println("Collection<String> stringCollection = mapStr.values(); -> "+stringCollection);
        System.out.println();

        // Set �� ���� ����-�������� (����� entrySet).
        Set<Map.Entry<Integer, String>> entries = mapStr.entrySet();
        System.out.println(entries );
        System.out.println();

    }
}
