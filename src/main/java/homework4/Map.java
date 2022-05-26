package homework4;

import java.util.Arrays;
import java.util.Scanner;

public class Map {

    private final char DOT_EMPTY = '•';
    private final char DOT_HUMAN = 'X';
    private final char DOT_AI = 'O';
    private final String HEADER_FIRST_SYMBOL = "♯";
    private final String SPACE_MAP = " ";


    private final int size;
    private final char[][] map;

    public int getSize() {
        return size;
    }

    public Map(int size) {
        this.size = size;
        this.map = new char[size][size];
        initializationMap(map);

    }

    public char getDotMap(int y, int x) {
        return map[y][x];
    }

    public boolean isCellFree(int rowNumber, int columnNumber) {
        return map[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private void initializationMap(char[][] map){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public void printMap() {
        System.out.println("\nИгровое поле:\n");
        printHeader(size);
        for (int i = 0; i < size; i++) {
            System.out.print((i+1) + spaceHeaderVertical(i+1));
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + spaceHeaderHorizontal(j+1));
            }
            System.out.println();
        }
    }

    private void printHeader(int size) {
        System.out.print(HEADER_FIRST_SYMBOL + spaceHeaderVertical(0));
        for (int i = 0; i < size ; i++) {
            System.out.print((i+1) + SPACE_MAP );
        }
        System.out.println();
    }

    private String spaceHeaderVertical(int currentLength) {
        String maxLength = Integer.toString(size);
        String currentLengthStr = Integer.toString(currentLength);
        return SPACE_MAP.repeat(maxLength.length() - currentLengthStr.length() + 1);
    }

    private String spaceHeaderHorizontal(int currentLength) {
        String currentLengthStr = Integer.toString(currentLength);
        return SPACE_MAP.repeat(currentLengthStr.length());
    }

    public void drawMap(int i, int j, char c) {
        map[i][j] = c;
    }

    public boolean isCheckDraw() {
        for (char[] chars : map) {
            for (char symbol : chars) {
                if (symbol == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public char getDOT_EMPTY() {
        return DOT_EMPTY;
    }

    public char getDOT_HUMAN() {
        return DOT_HUMAN;
    }

    public char getDOT_AI() {
        return DOT_AI;
    }



}
