package homework4;

import java.util.Random;

public class AI {


    private int rowNumber;
    private int columnNumber;

    Random random = new Random();
    private final Map map;

    public AI(Map map) {
        this.map = map;
    }


    public   void aiTurn() {
        System.out.println("ХОД КОМУКТЕРА!");


       while (true) {
            rowNumber = random.nextInt(map.getSize());
            columnNumber = random.nextInt(map.getSize());
            if (map.isCellFree(rowNumber, columnNumber)) {
                break;
            }
        }
        do {
            rowNumber = random.nextInt(map.getSize());
            columnNumber = random.nextInt(map.getSize());
        } while (!map.isCellFree(rowNumber, columnNumber));

        map.drawMap(rowNumber, columnNumber, map.getDOT_AI());

    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }



}
