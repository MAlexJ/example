package task_01;

import java.util.LinkedList;

public class TestMainLIst {

    public static void main(String[] args) {

        LinkedList<String> arrayList = new LinkedList<>();
        arrayList.add("str1");
        arrayList.add("str2");
        arrayList.add("str3");
        arrayList.add("str4");
        arrayList.addFirst("First");
        arrayList.removeFirst();
        arrayList.removeFirst();
        arrayList.removeFirst();
        arrayList.removeFirst();



        System.out.println(arrayList);





    }
}


