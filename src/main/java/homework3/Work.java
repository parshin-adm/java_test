package homework3;

import java.sql.Array;
import java.util.Arrays;

public class Work {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(createArray(5, 5)));

        //1
        int[] data1 = {1, 0, 1, 0, 0, 0, 0, 1, 1, 0};
        for (int i = 0; i < data1.length; i++) {

            if (data1[i] == 1)
                data1[i] = 0;
            else
                data1[i] = 1;
        }
        System.out.println(Arrays.toString(data1));

        //2
        int[] data2 = new int[100];
        for (int i = 0; i < data2.length; i++) {
            data2[i] = i + 1;
        }
        System.out.println(Arrays.toString(data2));

        //3
        int[] data3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < data3.length; i++) {
            if (data3[i] < 6)
                data3[i] *= 2;
        }
        System.out.println(Arrays.toString(data3));

        //4
        int[][] data4 = new int[5][5];
        for (int i = 0; i < data4.length; i++) {
            for (int j = 0; j < data4[i].length; j++) {
                if (i == j || i == data4[i].length - 1 - j)
                    data4[i][j] = 1;
                else
                    data4[i][j] = 0;

                System.out.print(data4[i][j] + " ");
            }
            System.out.println();
        }

        //5
        System.out.println(Arrays.toString(createArray(5, 5)));

        //6
        int[] data6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        findMinMaxArray(data6);

        //7
        int[] data7 = {2, 2, 2, 1, 2, 2,10, 1};
        System.out.println(isCheckBalance(data7));

        //8
        int[] data8 = {1, 2, 3};
        System.out.println(Arrays.toString(shiftArray(data8, 0)));

    }

    //5
    private static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    //6
    private static void findMinMaxArray(int[] data) {
        int min = data[0];
        int max = data[0];

        for (int i = 1; i < data.length; i++) {
            if (min > data[i])
                min = data[i];
            if (max < data[i])
                max = data[i];
        }
        System.out.printf("min = %d, max = %d%n", min, max);
    }

    //7
    private static boolean isCheckBalance(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i <= j)
                    sumLeft += array[j];
                else
                    sumRight += array[j];
            }
            if (sumLeft == sumRight)
                return true;
            else {
                sumLeft = 0;
                sumRight = 0;
            }
        }

        return false;
    }

    //8
    private static int[] shiftArray(int[] array, int n) {
        int tmp1 = array[0];
        int tmp2 = array[0];

        int shift = n % array.length;

        if(shift > 0) {
            for (int i = 0; i < shift; i++) {
                for (int j = 1; j < array.length; j++) {
                    tmp1 = array[j];
                    array[j] = tmp2;
                    tmp2 = tmp1;
                    if(j == array.length - 1) {
                        array[0] = tmp2;
                    }
                }
            }
        }
        else if(shift < 0) {
            for (int i = 0; i < -shift; i++) {
                for (int j = array.length -1; j >= 0; j--) {
                    tmp1 = array[j];
                    array[j] = tmp2;
                    tmp2 = tmp1;
                    if(j == 0) {
                        array[array.length-1] = tmp2;
                    }
                }
            }
        }
        return array;
    }




}







