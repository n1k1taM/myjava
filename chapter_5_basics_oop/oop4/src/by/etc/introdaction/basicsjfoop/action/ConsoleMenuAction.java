package by.etc.introdaction.basicsjfoop.action;

import by.etc.introdaction.basicsjfoop.structure.Cave;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenuAction {
    private Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        String menu = "1 - Show all the treasures; \n" +
                "2 - Choose the most expansive treasure; \n" +
                "3 - Select treasures for a given amount; \n" +
                "4 - Close the application";
        System.out.println(menu);
    }

    public int selection() {
        System.out.println("Enter a number from 1 to 4 ");
        while (scanner.hasNextInt() == false) {
            scanner.next();
            System.out.println("Enter a number from 1 to 4 ");
        }
        try {
            int mySelection = scanner.nextInt();
            if (mySelection < 1 || mySelection > 4) {
                System.out.println("You entered number, which there isn't in menu");
                selection();
            } else {
                return mySelection;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Try again.\n");
            selection();
        }
        return -1;
    }

    public boolean action(int selection, Cave cave) {
        // TreasureAction treasureAction = new TreasureAction();
        int cost = 0;
        switch (selection) {
            case 1:
                System.out.println("Show all the treasures; \n");
                cave.getTreasureAction().showAllTreasure();
                return false;
            case 2:
                System.out.println("Choose the most expansive treasure; \n");
                cave.getTreasureAction().chooseMostExpensive();
                return false;
            case 3:
                System.out.println("Select treasures for a given amount; \n");
                System.out.println("Enter the amount to select treasures");
                Scanner scanner = new Scanner(System.in);
                try {
                    cost = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Try again.");
                }
                cave.getTreasureAction().selectForGivenAmount(cost);
                return false;
            case 4:
                System.out.println("Close the application \n");
                return true;
        }
        return false;
    }
}
