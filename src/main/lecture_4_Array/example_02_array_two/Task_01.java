package example_02_array_two;

public class Task_01 {

    public static void main(String[] args) {

        int[][] arrays = {{28, 23}, {23, 26}};

        int[][] arrays1 = new int[2][2];

        arrays1[0][0] = 1;
        arrays1[0][1] = 2;
        arrays1[1][0] = 3;
        arrays1[1][1] = 4;

        int array2[][] = new int[3][];
        array2[0] = new int[1];
        array2[1] = new int[2];
        array2[2] = new int[3];

        int i, j, k = 0;
        for (i = 0; i < 3; i++) {
			for(j=0;j<i+1;j++){
                array2[i][j]=k++;
            }
        }

        for (i = 0; i < 3; i++) {
            for(j=0;j<i+1;j++){
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }

    }

}
