import java.sql.Array;
import java.util.Arrays;

public class Work {
    public static void main(String[] args) {
//        reverseArray();
//        createArray();
//        multiplyArray();
        //createTwoArray();
        //int[] array = createArray(5, 1);
        //System.out.println(Arrays.toString(array));
        //FindMinMaxArray();
        int[] a = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(a));

    }


    private static void reverseArray() {
        int[] array = {1, 0, 1, 0, 0, 0, 0, 1, 1, 0};
        for (int i = 0; i < array.length; i++) {

            if(array[i] == 1)
                array[i] = 0;
            else
                array[i] = 1;
        }
        System.out.println(Arrays.toString(array));
    }
    private static void createArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        System.out.println(Arrays.toString(array));
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
    //умножить на 2;

    private static void multiplyArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 6)
                array[i] *= 2;
        }
        System.out.println(Arrays.toString(array));
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
    //одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
    //(можно только одну из диагоналей, если обе сложно). Определить элементы одной из
    //диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0],
    //[1][1], [2][2], …, [n][n];

    private static void createTwoArray() {
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(i == j || i == array[i].length - 1 - j)
                    array[i][j] = 1;
                else
                    array[i][j] = 0;

                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    //Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
    //одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;

    private static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    //Задать одномерный массив и найти в нем минимальный и максимальный элементы

    private static void FindMinMaxArray() {
        int[] array = {1, 2, -5, 3, 4, 5, 6, 7, 8, 9, 10};
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length ; i++) {
            if(min > array[i])
                min = array[i];
            if(max < array[i])
                max = array[i];
        }
        System.out.println("Min = " + min + ", Max = " + max);
    }

    //7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
    //массива равны.
    //Примеры:
    //checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
    //checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1

    private static boolean checkBalance(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                sum += array[j];
            }
            if(array[i] == sum)
                return true;

        }

        return false;
    }






}
