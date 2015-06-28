package lecture_01_exeption_syntax.task_02;


public class ArrayIntTestMain {

    private int[] items;
    private int next;

    public ArrayIntTestMain(int size) {
        this.items = new int[size];
    }


    public void add(int x) {
        if (next < items.length) {
            items[next++] = x;
        } else {
            System.out.println("Array is full");
        }
    }

    class ArraySelector implements Selector {
        private int i;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public int current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new ArraySelector();
    }

    public static void main(String[] args) {
        int size = 7;
        ArrayIntTestMain array = new ArrayIntTestMain(size);
        for (int i = 0; i < size; i++) {
            array.add(i);
        }

        //Inner class
        Selector selector = array.selector();
        while (!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }

    }

}
