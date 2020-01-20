package by.etc.introdaction.strings;

import java.util.Scanner;

public class AmountOfNumbers {
    public static void main(String[] args) {

        String str = " ";
        int amount = 0; //для подсчета чисел
        boolean flag = false; //для различия между цифрой и числом

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the string");
            str = sc.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("You entered invalid characters");
            System.exit(0);
        }

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                // если flag= false, то предыдущий char не являлся цифрой (новое число -> amount++)
                //если flag= true, то предыдущий char являлся цифрой (все еще одно и то же число -> не нужно увеличивать amount)
                if (flag == false) {
                    amount++;
                    flag = true;
                }
            } else {
                flag = false;
            }
        }
        System.out.println("Amount of numbers: " + amount);
    }
}
