package by.etc.introdaction.strings;

import java.util.Scanner;

//Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
//длинных слов может быть несколько, не обрабатывать.
public class LongestWord {
    public static void main(String[] args) {
        String str = new String();
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the string");
            str = sc.nextLine();
        } catch (Exception e) {
            System.out.println("You entered invalid symbols");
        }

        String[] array = str.split(" ");
        str = "";
        for (String s : array) {
            if (str.length() < s.length()) {
                str = s;
            }
        }
        System.out.println(str);
    }
}
