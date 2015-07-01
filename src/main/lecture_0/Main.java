
public class Main {
    public static void main(String[] args) {
        int mat[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        try {
            fun(mat, 0, 0);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void fun(int[] tab, int i, int j) {
        for (int k = 0; k < i; k++) {
            System.out.print(" I " + tab[k] + " , ");
        }
        System.out.println();
    }


    public static int fun(int[][] tab, int i, int j) {
        if (i >= 0 && j >= 0) {
            System.out.println(" H " + tab[i][j]);
            return tab[i][j] + fun(tab, i + 1, j + 1);
        } else
            return 0;
    }
}
