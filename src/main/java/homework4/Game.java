package homework4;

import java.util.Scanner;

public class Game {
    private int turnsCount = 0;
    private int size;

    private Scanner in = new Scanner(System.in);
    private Map map;
    private Human human;
    private AI ai;


    public void turnGame() {
        do {
            System.out.println("\n\nДобро пожаловать в игру крестики-нолики!");
            init();
            playGame();
        } while (isContinueGame());
        endGame();
    }

    private void init() {
        size = initSize();
        map = new Map(size);
        ruleGame(size);
        map.printMap();
        human = new Human(map);
        ai = new AI(map);

    }

    private void playGame() {
        while (true) {
            human.humanTurn();
            map.printMap();
            turnsCount++;
            if (checkEnd(turnsCount)) {
                break;
            }

            ai.aiTurn();
            map.printMap();
            turnsCount++;
            if (checkEnd(turnsCount)) {
                break;
            }
        }
    }

    private boolean isRuleGame() {
        System.out.println("Желаете ознакомится с правилами для вашего размера поля? y\\n");
        return switch (in.next()) {
            case "y", "yes", "да", "+", "д" -> true;
            default -> false;
        };
    }
    private void ruleGame(int size) {
        if(isRuleGame()) {
            switch (size) {
                case 3,4,5,6 -> System.out.println("Победная серия равна 3");
                case 7,8,9,10 -> System.out.println("Победная серия равна 4");
                default ->  System.out.println("Победная серия равна 5");
            };
        }
    }

    private int initSize() {
        System.out.println("Введите нужный размер поля. P.S. " +
                "Не рекомендуем размер поля делать больше 9!");
        int size;
        while (true) {
            if (in.hasNextInt()) {
                size = in.nextInt();
                if(isSizeValid(size)) {
                    break;
                }
                }
            else {
                System.out.println("Нужно ввести целочисленное число. Давайте попробуем снова!");
                in.next();
            }
        }
        return size;
    }

    private static boolean isSizeValid(int size) {
        if(size > 2) {
            return true;
        }
        System.out.println("Размер поля должен быть больше или равен 3м");
        return false;
    }

    private void endGame() {
        in.close();
        System.out.println("Ты заходи, если что");
    }

    private boolean isContinueGame() {
        System.out.println("Хотите продолжить? y\\n");
        return switch (in.next()) {
            case "y", "yes", "да", "+", "д" -> true;
            default -> false;
        };
    }

    private boolean checkEnd(int turnsCount) {

       if(turnsCount %2 != 0) {
           if(checkWin(human.getRowNumber(), human.getColumnNumber())){
               System.out.println("Человек победил");
               return true;
           }
       }
       else {
           if(checkWin(ai.getRowNumber(), ai.getColumnNumber())){ //AI
               System.out.println("Компьютер победил");
               return true;
           }
       }
       return turnsCount == map.getSize();

    }

    private boolean checkWin(int x, int y) {
        

        return false;
    }




}
