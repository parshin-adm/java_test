package homework4;

import java.util.Arrays;
import java.util.Scanner;

public class Map {

    private Scanner scanner = new Scanner(System.in);
    private char[][] map;
    private int size;

    private void createMap(){
        System.out.println("Доброе пожаловать в игру! Введите нужный размер поля, " +
                "где минимальный размер поля равен 3, а максимальный 100");
        while (true) {
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if(size > 2 && size <=15 ) {
                    break;
                }
                else {
                    System.out.printf("Размер поля равный %d не соответствует нужному диапазону %%n", size);
                }
            } else {
                System.out.println("Нужно ввести целочисленное число");
            }
        }
        map = new char[size][size];
    }

    private void fillMap(char[][] map){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = '●';
            }
        }
    }

    public void startMap() {
        createMap();
        fillMap(map);
        printMap();
    }

    private void printHeader(int size) {
        System.out.print(spaceHeader(size));
        for (int i = 0; i < size ; i++) {
            System.out.print((i+1) + spaceHeader(i+1));
        }
        System.out.println();
    }

    private String spaceHeader(int length) {
        String space = Integer.toString(length);
        return " ".repeat(space.length());
    }

    private String spaceHeaderStr(int length) {
        String space = Integer.toString(length);
        if(length == 0) {
            return "";
        }
        return " ".repeat(space.length());
    }

    private void printMap() {
        printHeader(size);
        for (int i = 0; i < size; i++) {
            System.out.print((i+1) + spaceHeaderStr(size - 1 - i) );
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + spaceHeader(j));
            }
            System.out.println();
        }
    }


}
