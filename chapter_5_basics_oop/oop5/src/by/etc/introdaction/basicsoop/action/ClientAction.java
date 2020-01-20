package by.etc.introdaction.basicsoop.action;

import by.etc.introdaction.basicsoop.structure.Client;
import by.etc.introdaction.basicsoop.structure.Gift;
import by.etc.introdaction.basicsoop.sweets.*;
import by.etc.introdaction.basicsoop.wrap.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientAction {
    private static Scanner scanner = new Scanner(System.in);
    private static Client client = new Client();

    public void start() {
        System.out.println("Hello! How can I call you?");
        client.setName(checkInputName());

        GiftCreator giftCreator = new GiftCreator();

        String giftName = chooseNameOfGift();
        String wrapType = chooseWrap();
        double cost = choosePrice();
        client.setGift(giftCreator.createGift(cost, wrapType, giftName));

        printPresent(client.getGift());
    }


    public static String checkInputName() {
        Pattern pattern = Pattern.compile("([a-zA-Z]{2,15}(\\s*)){1,3}");
        while (!scanner.hasNext(pattern)) {
            scanner.nextLine();
            System.out.println("Invalid input. Make sure that the name was written right.");
        }
        return scanner.nextLine();
    }

    public static double checkInputPrice() {
        Pattern pattern = Pattern.compile("[\\d ]{1,3}");
        scanner.useDelimiter("[\r\n]");
        while (true) {
            while (!scanner.hasNext(pattern)) {
                scanner.nextLine();
                System.out.println("The cost of goods can be from 1 to 999");
            }
            double input = scanner.nextDouble();
            if (input >= 1 && input <= 999) {
                return input;
            } else {
                System.out.println("The cost of gift can be from 1 to 999");
            }
        }
    }

    public static double choosePrice() {
        System.out.println(" You can choose price in limit from 1 to 999");
        return checkInputPrice();
    }

    public static String chooseWrap() {
        System.out.println(client.getName() + ", You can choose one of the types of wraps:");
        System.out.println(String.format("1. Cardboard box;\n2. Metal Box;\n" + "3. Plastic wrap;\n4. Pocket wrap "));
        System.out.println("Enter packing option number");
        int option = checkInputOption();
        String wrap = null;
        switch (option) {
            case 1:
                wrap = "Cardboard";
                break;
            case 2:
                wrap = "Metal";
                break;
            case 3:
                wrap = "Plastic";
                break;
            case 4:
                wrap = "Pocket";
        }
        return wrap;
    }

    private static int checkInputOption() {
        Pattern pattern = Pattern.compile("[1-4]");
        scanner.useDelimiter("[\r\n]");
        while (!scanner.hasNext(pattern)) {
            scanner.nextLine();
            System.out.println("Invalid input. Enter 1, 2, 3 or 4");
        }
        return scanner.nextInt();
    }

    public static String chooseNameOfGift() {
        System.out.println("Enter the name of gift:");
        return checkInputNameOfGift();
    }

    private static String checkInputNameOfGift() {
        Pattern pattern = Pattern.compile("([a-zA-Z]{2,15}(\\s*)){1,5}");
        while (!scanner.hasNext(pattern)) {
            scanner.nextLine();
            System.out.println("Invalid input. Make sure that the name was written right.");
        }
        return scanner.nextLine();
    }

    public void printPresent(Gift gift) {
        System.out.println(gift);
    }

}
