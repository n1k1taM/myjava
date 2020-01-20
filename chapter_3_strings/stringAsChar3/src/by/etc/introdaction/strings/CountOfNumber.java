package by.etc.introdaction.strings;

import java.util.Scanner;
//В строке найти количество цифр.
public class CountOfNumber {

    public static void main(String[] args) {

        String str = new String();
        int count = 0;

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the string:");
            str = sc.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("You entered invalid characters");
            System.exit(0);
        }

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        System.out.println("Number of digits: " + count);
    }
}
