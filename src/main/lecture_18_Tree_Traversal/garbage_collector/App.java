package garbage_collector;

public class App {

    // флаг -verbose:gc
    public static void main(String[] args) {
//
//        for (int k = 0; k < Integer.MAX_VALUE; k++) {
//            System.out.println(k);
//            Object ref = new byte[10_000_000];
//
//        }


       // Сдох GC  в мучениях
            Object ref = null;
            for (int k = 0; k < Integer.MAX_VALUE; k++) {
                System.out.println(k);
                ref = new Object[] {ref, new byte[2_000_000]};

        }
        // GC запускался ПОСЛЕ КАЖДОГО ВЫДЕЛЕНИЯ ПАМЯТИ в попытке спасти JVM от падения.
    }

}
