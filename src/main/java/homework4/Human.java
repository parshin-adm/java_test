package homework4;

import java.util.Scanner;

public class Human {

    private int rowNumber;
    private int columnNumber;


    Scanner in = new Scanner(System.in);
    private final Map map;

    public Human(Map map) {
        this.map = map;
    }

    public void humanTurn() {
        System.out.println("ХОД ЧЕЛОВЕКА!");

        while (true) {
            System.out.print("Введите координату строки: ");
            rowNumber = getValidNumberFromScanner() - 1;

            System.out.print("Введите координату столбца: ");
            columnNumber = getValidNumberFromScanner() - 1;

            if (map.isCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.printf("Ячейка с координатами: %d:%d уже занята%n%n", rowNumber + 1, columnNumber + 1);
        }
        map.drawMap(rowNumber, columnNumber, map.getDOT_HUMAN());

    }

    private int getValidNumberFromScanner() {
        while (true) {
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (isNumberValid(n)) {
                    return n;
                }
                System.out.println("!!!Проверьте значение координаты. Должно быть от 1 до " + map.getSize());
            } else {
                System.out.println("!!!Ввод допускает лишь целые числа!");
                in.next();
            }
        }
    }

    private boolean isNumberValid(int n) {
        return n >= 1 && n <= map.getSize();
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }
}
