package lecure_01_exeption_syntax.task_01;


import java.util.HashMap;
import java.util.Map;

/**
 * Map - объект, который хранит пары ключ-значение и не может содержать повторяющихся ключей.
 * При добавлении элемента по существующему ключу происходит запись нового элемента по ключу вместо старого.
 * Это демонстрирует следующий пример:
 */
public class TestMap_01 {

    public static void main(String[] args) {
        Map<String, String> mapStr = new HashMap<>();
        mapStr.put("1", "asd");
        mapStr.put("1", "ewq");

        //Вывод Map на экран  System.out.println()
        System.out.println(mapStr);
    }

}
