package by.etc.introdaction.basicsjfoop.action;

import by.etc.introdaction.basicsjfoop.DragonAndTreasureMain;
import by.etc.introdaction.basicsjfoop.structure.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureAction {


    void showAllTreasure() {
        int id = 1;
        for (Treasure element : this.fillCaveWithTreasures()) {
            System.out.println(element);
        }
        System.out.println();
    }

    void chooseMostExpensive() {
        int highestPrice = 0;
        Treasure treasure = null;
        for (Treasure element : this.fillCaveWithTreasures()) {
            if (element.getPriceTreasure() > highestPrice) {
                highestPrice = element.getPriceTreasure();
                treasure = element;
            }
        }
        System.out.println(treasure + "\n");

    }

    void selectForGivenAmount(int cost) {
        List<Treasure> treasures = new ArrayList<>();
        for (Treasure element : this.fillCaveWithTreasures()) {
            if (element.getPriceTreasure() <= cost) {
                treasures.add(element);
                cost = cost - element.getPriceTreasure();
            }
        }
        if (treasures.size() == 0) {
            System.out.println("No options found.\n");
            return;
        }
        int id = 1;
        for (Treasure element : treasures) {
            System.out.println(String.format("%-3d %-100s", id++, element));
        }
        System.out.println();
    }

    public List<Treasure> fillCaveWithTreasures() {
        List<Treasure> treasures = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src\\by\\etc\\introdaction\\basicsjfoop\\data\\list_treasures.txt");
            Scanner scanner = new Scanner(fileReader);
            int i = 100;
            while (scanner.hasNextLine() && i-- > 0) {
                String[] treasureLine = scanner.nextLine().split(" - ");
                String treasureType = treasureLine[0];
                String descriptionOfTreasure = treasureLine[1];
                int treasureValue = Integer.parseInt(treasureLine[2].trim());
                switch (treasureType) {
                    case "Coins":
                        treasures.add(new Coins(treasureType, treasureValue, descriptionOfTreasure));
                        break;
                    case "Diamonds":
                        treasures.add(new Diamonds(treasureType, treasureValue, descriptionOfTreasure));
                        break;
                    case "Gold":
                        treasures.add(new Gold(treasureType, treasureValue, descriptionOfTreasure));
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Treasure information file not found.");
        }
        return treasures;
    }
}
