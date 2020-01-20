package by.etc.introdaction.strings;

import java.util.Scanner;

//Проверить, является ли заданное слово палиндромом
public class Palindrome {
    public static void main(String[] args) {

        String str = new String();
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the word:");
            if (sc.hasNext()) {
                str = sc.next();
            }
        } catch (NumberFormatException e) {
            System.out.println("You entered invalid characters");
            System.exit(0);
        }

        StringBuilder sb = new StringBuilder(str).reverse();
        String strRev = sb.toString();
        System.out.println(str);

        if (str.equalsIgnoreCase(strRev)) {
            System.out.println("word is palindrome");
        } else {
            System.out.println("word is not palindrome");
        }
    }
}
